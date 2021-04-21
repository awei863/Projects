import pygame
import random
from settings import *
from sprites import *
from os import path

class Game:
    def __init__(self): # when the game starts up initialize game window
        pygame.mixer.pre_init(44100, -16, 4, 2048)
        pygame.init()
        pygame.mixer.init()
        self.screen = pygame.display.set_mode((WIDTH, HEIGHT))
        pygame.display.set_caption(TITLE)
        self.clock = pygame.time.Clock()
        self.running = True
        self.font = pygame.font.match_font(FONT)

        self.load_data()

    def load_data(self):
        self.dir = path.dirname(__file__) # load high score
        with open(path.join(self.dir, HIGHSCORE_FILE), 'r') as f:
            try:
                self.highscore = int(f.read())
            except:
                self.highscore = 0 # if no scores

        self.jump_sound = pygame.mixer.Sound("./sounds/jump2.wav")
        self.fly_sound = pygame.mixer.Sound("./sounds/flying.wav")
        self.die_sound = pygame.mixer.Sound("./sounds/die.wav")
        self.cell_sound = pygame.mixer.Sound("./sounds/cell.wav")
        self.frieza_sound = pygame.mixer.Sound("./sounds/frieza.wav")
        self.buu_sound = pygame.mixer.Sound("./sounds/buu.wav")

        self.cloud_images = []
        for i in range(1, 4):
            self.cloud_images.append(pygame.image.load("./images/cloud{}.png".format(i)).convert())
    
    def new(self): # start new game
        self.score = 0
        self.all_sprites = pygame.sprite.LayeredUpdates()
        self.platforms = pygame.sprite.Group()
        self.powerups = pygame.sprite.Group()
        self.mobs = pygame.sprite.Group()
        self.clouds = pygame.sprite.Group()
        self.player = Player(self)
        

        for plat in PLATFORM_LIST:
            Platform(self, *plat)
            
        self.mob_timer = 0

        pygame.mixer.music.load("./sounds/playing.ogg")

        for i in range(8): # spawn some clouds at start
            c = Cloud(self)
            c.rect.y += 500

        self.run()

    def run(self): # game loop
        pygame.mixer.music.play(loops=-1)
        self.playing = True
        while self.playing:
            self.clock.tick(FPS)
            self.events()
            self.update()
            self.draw()
        
        pygame.mixer.music.fadeout(500)

    def update(self): # game loop - update
        self.all_sprites.update()

        now = pygame.time.get_ticks()
        if now - self.mob_timer > 5000 + random.choice([-1000, -500, 0, 500, 1000]):
            self.mob_timer = now
            Mob(self)

        mob_hits = pygame.sprite.spritecollide(self.player, self.mobs, False, pygame.sprite.collide_mask)
        if mob_hits:
            self.die_sound.play()
            self.playing = False


        hits = pygame.sprite.spritecollide(self.player, self.platforms, False) # check if hit platform while falling

        if self.player.vel.y > 0:
            if hits:
                lowest = hits[0]
                for hit in hits: # find the lowest platform incase it stacks
                    if hit.rect.bottom > lowest.rect.bottom:
                        lowest = hit
                if self.player.pos.x < lowest.rect.right + 10 and self.player.pos.x > lowest.rect.left - 10: # player fall off edge of platform
                    if self.player.pos.y < lowest.rect.centery: # player bottom hit top of platform
                        self.player.pos.y = lowest.rect.top
                        self.player.vel.y = 0
                        self.player.jumping = False

        if self.player.rect.top <= HEIGHT / 4: # scroll up when reached
            if random.randrange(100) < 10:
                Cloud(self)
            self.player.pos.y += max(abs(self.player.vel.y), 2)
            for cloud in self.clouds:
                cloud.rect.y += max(abs(self.player.vel.y / 2), 2)
            for mob in self.mobs:
                mob.rect.y += max(abs(self.player.vel.y), 2)
            for plat in self.platforms:
                plat.rect.y += max(abs(self.player.vel.y), 2)
                if plat.rect.top >= HEIGHT:
                    plat.kill() # remove platforms off the screen
                    self.score += 10

        pow_hits = pygame.sprite.spritecollide(self.player, self.powerups, True) # powerup when hit
        for pow in pow_hits: 
            if pow.type == 'boost':
                self.fly_sound.play()
                self.player.vel.y = -BOOST_POWER
                self.player.jumping = False


        if self.player.rect.bottom > HEIGHT: # fall and die
            for sprite in self.all_sprites:
                sprite.rect.y -= max(self.player.vel.y, 10)
                if sprite.rect.bottom < 0:
                    sprite.kill()
        if len(self.platforms) == 0:
            self.playing = False
            self.die_sound.play()

        while len(self.platforms) < 10: # spawn platforms
            width = random.randrange(50, 100)
            Platform(self, random.randrange(0, WIDTH - width),
                     random.randrange(-75, -30))
            

    def events(self): # game loop - events
        
        for event in pygame.event.get():
            # keys = pygame.key.get_pressed()
            if event.type == pygame.QUIT:
                if self.playing:
                    self.playing = False
                self.running = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    self.player.jump()
                    
                # if keys[pygame.K_SPACE] and keys[pygame.K_LEFT]:
                #     self.player.jump()
                # if keys[pygame.K_SPACE] and keys[pygame.K_RIGHT]:
                #     self.player.jump()
            if event.type == pygame.KEYUP: # jump height depending on time on spacebar
                if event.key == pygame.K_SPACE:
                    self.player.jump_cut()

    def draw(self): # game loop - draw      
        # self.screen.fill(BACKGROUND)
        self.screen.blit(BACKGORUND_IMG, (-110,0))
        self.all_sprites.draw(self.screen)
        
        self.draw_text("Score: " + str(self.score), 22, BLUE, WIDTH / 2, 15)
        pygame.display.flip() # flip display after drawing everything

    def show_start_screen(self): # start screen
        pygame.mixer.music.load("./sounds/start.ogg")
        pygame.mixer.music.play(loops=-1)
        # self.screen.fill(BACKGROUND)
        self.screen.blit(START_IMG, (0,0))
        self.draw_font(TITLE, 66, CUSTOM_RED, WIDTH / 2, HEIGHT / 4)
        self.draw_font("Arrows to move Hold Space to jump!", 33, CUSTOM_RED, WIDTH / 2, (HEIGHT * 3 / 4) + 110)
        self.draw_font("Press a key to play", 33, CUSTOM_RED, WIDTH / 2, (HEIGHT * 3 / 4) + 50)
        self.draw_text("High Score: " + str(self.highscore), 33, CUSTOM_RED, WIDTH / 2, 15)
        pygame.display.flip()
        self.wait_for_key_up()
        pygame.mixer.music.fadeout(500)
        

    def show_gameover_screen(self): # game over/continue screen
        
        if not self.running: # exit game if not running instead of going to game over screen
            return
        pygame.mixer.music.load("./sounds/gameover.ogg")
        pygame.mixer.music.play(loops=-1)
        # self.screen.fill(BACKGROUND)
        self.screen.blit(GAMEOVER_IMG, (-50,0))
        self.draw_font("GAME OVER", 88, YELLOW, WIDTH / 2, HEIGHT / 4)
        self.draw_text("Score: " + str(self.score), 22, YELLOW, WIDTH / 2, (HEIGHT / 2) + 50)
        self.draw_font("Press a key to play again", 33, YELLOW, WIDTH / 2, (HEIGHT * 3 / 4) + 50)
        if self.score > self.highscore: # update high score in file
            self.highscore = self.score
            self.draw_text("NEW HIGH SCORE!", 22, YELLOW, WIDTH / 2, HEIGHT / 2 + 20)
            with open(path.join(self.dir, HIGHSCORE_FILE), 'w') as f:
                f.write(str(self.score))
        else:
            self.draw_text("High Score: " + str(self.highscore), 22, YELLOW, WIDTH / 2, HEIGHT / 2 + 90)

        pygame.display.flip()
        self.wait_for_key_down()

    def wait_for_key_down(self):
        waiting = True
        while waiting:
            self.clock.tick(FPS)
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    waiting = False
                    self.running = False
                if event.type == pygame.KEYDOWN:
                    waiting = False
                    
    def wait_for_key_up(self):
        waiting = True
        while waiting:
            self.clock.tick(FPS)
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    waiting = False
                    self.running = False
                if event.type == pygame.KEYUP:
                    waiting = False
    

    def draw_text(self, text, size, color, x, y):
        # font = pygame.font.Font("./fonts/dbz.ttf", size) # only shows letters
        font = pygame.font.Font(self.font, size)
        text_surface = font.render(text, True, color)
        text_rect = text_surface.get_rect()
        text_rect.midtop = (x, y)
        self.screen.blit(text_surface, text_rect)

    def draw_font(self, text, size, color, x, y):
        # font = pygame.font.Font("./fonts/dbz.ttf", size) # only shows letters
        font = pygame.font.Font("./fonts/dbz.ttf", size)
        text_surface = font.render(text, True, color)
        text_rect = text_surface.get_rect()
        text_rect.midtop = (x, y)
        self.screen.blit(text_surface, text_rect)

g = Game()
g.show_start_screen()
while g.running:
    g.new()
    g.show_gameover_screen()

pygame.quit()