import pygame
pygame.init()
pygame.font.init()
# game window
TITLE = "Dragon Ball JumpZ"
WIDTH = 480
HEIGHT = 600
FPS = 60
# DBZ_FONT = pygame.font.Font("./fonts/dbz2.ttf", 26)
FONT = 'broadway'
HIGHSCORE_FILE = "highscore.txt"

# player
PLAYER_ACC = 0.5
PLAYER_FRICTION = -0.12
PLAYER_GRAVITY = 0.8
PLAYER_JUMP = 20

# platforms
PLATFORM_LIST = [(0, HEIGHT - 60),
                (WIDTH / 2 - 50, HEIGHT * 3 / 4 - 50),
                (125, HEIGHT - 350),
                (350, 200),
                (175, 100)]

# properties
BOOST_POWER = 60
POWER_SPAWN_PCT = 10
MOB_FREQ = 5000
PLAYER_LAYER = 2
PLATFORM_LAYER = 1
POWER_LAYER = 2
MOB_LAYER = 2
CLOUD_LAYER = 0

# colors
WHITE = (255, 255 ,255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
YELLOW = (255, 255, 0)
CUSTOM_YELLOW = (237, 188, 36)
CUSTOM_ORANGE = (237, 140, 36)
CUSTOM_RED = (237, 96, 36)
BACKGROUND = (0, 155, 155)
BACKGORUND_IMG = pygame.image.load("./images/background.png")
START_IMG = pygame.image.load("./images/start.jpg")
START_IMG = pygame.transform.scale(START_IMG, (500, 650))
GAMEOVER_IMG = pygame.image.load("./images/end.jpg")
GAMEOVER_IMG = pygame.transform.scale(GAMEOVER_IMG, (700, 600))
