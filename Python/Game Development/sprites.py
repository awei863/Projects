import pygame
from settings import *
import random
vector = pygame.math.Vector2

class Player(pygame.sprite.Sprite):

    def __init__(self, game):
        self._layer = PLAYER_LAYER
        self.groups = game.all_sprites
        pygame.sprite.Sprite.__init__(self, self.groups)
        self.game = game

        self.walking = False
        self.jumping = False
        self.current_frame = 0
        self.last_update = 0
        self.load_images()

        self.image = self.standing
 
        self.rect = self.image.get_rect() 
        self.rect.center = (40, HEIGHT - 100)
        self.pos = vector(40, HEIGHT - 100) # adding velocity and acceleration to player
        self.vel = vector(0, 0)
        self.acc = vector(0, 0)

    def load_images(self):
        
        self.standing = pygame.image.load("./images/goku0.png")
        self.standing = pygame.transform.scale(self.standing, (40, 70))
        self.walk_frames_rr = [pygame.image.load("./images/goku1.png"),
                              pygame.image.load("./images/goku2.png"),
                              pygame.image.load("./images/goku3.png")]
        
        self.walk_frames_r = []

        for img in self.walk_frames_rr: # resize imgs   
            self.img_item = pygame.transform.scale(img, (40, 70))
            self.walk_frames_r.append(self.img_item)

        self.walk_frames_l = []
        for frame in self.walk_frames_r: # flip imgs
            self.walk_frames_l.append(pygame.transform.flip(frame, True, False))
        
        self.jump_frame = pygame.image.load("./images/jump1.png")
        self.jump_frame = pygame.transform.scale(self.jump_frame, (40, 70))

    def jump(self): # only if standing on something
        self.rect.x += 2
        hits = pygame.sprite.spritecollide(self, self.game.platforms, False)
        self.rect.x -= 2
        if hits and not self.jumping:
            self.game.jump_sound.play()
            self.jumping = True
            self.vel.y = -PLAYER_JUMP

        bottom = self.rect.bottom
        self.image = self.jump_frame
        self.rect = self.image.get_rect()
        self.rect.bottom = bottom

   
        
    def jump_cut(self):
        if self.jumping:
            if self.vel.y < -3:
                self.vel.y = -3


    def update(self):
        self.animate()
        self.acc = vector(0, PLAYER_GRAVITY)
      
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT]:
            self.acc.x = -PLAYER_ACC
        if keys[pygame.K_RIGHT]:
            self.acc.x = PLAYER_ACC
        
        self.acc.x += self.vel.x * PLAYER_FRICTION # adding friction to player    
        self.vel += self.acc
        if abs(self.vel.x) < 0.1:
            self.vel.x = 0
        self.pos += self.vel + 0.5 * self.acc # equation for motion

        if self.pos.x > WIDTH + self.rect.width / 2: # make player wrap around sides smoother instead of going off screen 
            self.pos.x = 0 - self.rect.width / 2
        if self.pos.x < 0 - self.rect.width / 2:
            self.pos.x = WIDTH + self.rect.width /2


        self.rect.midbottom = self.pos

    def animate(self):
        now = pygame.time.get_ticks()

        if self.vel.x != 0:
            self.walking = True
        else:
            self.walking = False
        
        if self.walking: # walking animation
            if now - self.last_update > 100:
                self.last_update = now
                self.current_frame = (self.current_frame + 1) % len(self.walk_frames_l)
                bottom = self.rect.bottom
                if self.vel.x > 0:
                    self.image = self.walk_frames_r[self.current_frame]
                else:
                    self.image = self.walk_frames_l[self.current_frame]
                self.rect = self.image.get_rect()
                self.rect.bottom = bottom

        if self.walking and self.jumping: # jumping animation with right/left
            bottom = self.rect.bottom
            if self.vel.x > 0:
                self.image = self.jump_frame
            else:
                self.image = pygame.transform.flip(self.jump_frame, True, False)
                
            self.rect = self.image.get_rect()
            self.rect.bottom = bottom

        
        if not self.jumping and not self.walking: # standing straight when still
            if now - self.last_update > 10:
                self.last_update = now
                bottom = self.rect.bottom
                self.image = self.standing
                self.rect = self.image.get_rect()
                self.rect.bottom = bottom

        self.mask = pygame.mask.from_surface(self.image)

        

       

class Platform(pygame.sprite.Sprite):
    def __init__(self, game, x, y):
        self._layer = PLATFORM_LAYER
        self.groups = game.all_sprites, game.platforms
        pygame.sprite.Sprite.__init__(self, self.groups)
        self.game = game
        images = [pygame.image.load("./images/platform3.png"),
                  pygame.image.load("./images/platform4.png")]
        self.image = random.choice(images)
        self.image.set_colorkey(BLACK)
        self.rect = self.image.get_rect()
        self.rect.x = x
        self.rect.y = y
        if random.randrange(100) < POWER_SPAWN_PCT: # spawn powerup 
            Powerup(self.game, self)

class Powerup(pygame.sprite.Sprite):
    def __init__(self, game, plat):
        self._layer = POWER_LAYER
        self.groups = game.all_sprites, game.powerups
        pygame.sprite.Sprite.__init__(self, self.groups)
        self.game = game
        self.plat = plat
        self.type = random.choice(["boost"])
        self.image = pygame.image.load("./images/senzubean.png")
        self.image = pygame.transform.scale(self.image, (50, 50))
        
        self.rect = self.image.get_rect()
        self.rect.centerx = self.plat.rect.centerx
        self.rect.bottom = self.plat.rect.top - 5

    def update(self):
        self.rect.bottom = self.plat.rect.top - 5
        if not self.game.platforms.has(self.plat): # delete power up if platform is gone
            self.kill()

class Mob(pygame.sprite.Sprite):
    def __init__(self, game):
        self._layer = MOB_LAYER
        self.groups = game.all_sprites, game.mobs
        pygame.sprite.Sprite.__init__(self, self.groups)
        self.game = game
        self.image_one = pygame.image.load("./images/frieza1.png")
        self.image_two = pygame.image.load("./images/frieza2.png")
        self.image = self.image_one
        self.rect = self.image.get_rect()
        self.rect.centerx = random.choice([-100, WIDTH + 100]) # start left/right offscreen
        
        if self.game.score > 2000: # increase difficulty
            self.vx = random.randrange(7, 12)
            self.image_one = pygame.image.load("./images/buu1.png")
            self.image_two = pygame.image.load("./images/buu2.png")
            if self.rect.centerx == -100 and self.vx > 0: # play enemy sound
                self.game.buu_sound.play()
            if self.rect.centerx == WIDTH + 100 and self.vx > 0:
                self.game.buu_sound.play()
        elif self.game.score > 1000:
            self.vx = random.randrange(4, 6)
            self.image_one = pygame.image.load("./images/cell2.png")
            self.image_two = pygame.image.load("./images/cell3.png")
            if self.rect.centerx == -100 and self.vx > 0:
                self.game.cell_sound.play()
            if self.rect.centerx == WIDTH + 100 and self.vx > 0:
                self.game.cell_sound.play()
        else:
            self.vx = random.randrange(1, 3)
            if self.rect.centerx == -100 and self.vx > 0:
                self.game.frieza_sound.play()
            if self.rect.centerx == WIDTH + 100 and self.vx > 0:
                self.game.frieza_sound.play()
        
        if self.rect.centerx > WIDTH:
            self.vx *= -1
        self.rect.y = random.randrange(HEIGHT / 2)
        self.vy = 0
        self.dy = 0.5

    def update(self):
        self.rect.x += self.vx # animate up and down motion
        self.vy += self.dy
        if self.vy > 3 or self.vy < -3:
            self.dy *= -1
        center = self.rect.center
        if self.dy < 0:
            self.image = self.image_one
        else:
            self.image = self.image_two
        self.rect = self.image.get_rect()
        self.mask = pygame.mask.from_surface(self.image)
        self.rect.center = center
        self.rect.y += self.vy
        if self.rect.left > WIDTH + 100 or self.rect.right < -100:
            self.kill()

        
class Cloud(pygame.sprite.Sprite):
    def __init__(self, game):
        self._layer = CLOUD_LAYER
        self.groups = game.all_sprites, game.clouds
        pygame.sprite.Sprite.__init__(self, self.groups)
        self.game = game
        self.image = random.choice(self.game.cloud_images)
        self.image.set_colorkey(BLACK)
        self.rect = self.image.get_rect()
        scale = random.randrange(50, 101) / 100
        self.image = pygame.transform.scale(self.image, (int(self.rect.width * scale),
                                                         int(self.rect.height * scale)))
        self.rect.x = random.randrange(WIDTH - self.rect.width)
        self.rect.y = random.randrange(-500, -50)
    
    def update(self):
        if self.rect.top > HEIGHT * 2:
            self.kill()

