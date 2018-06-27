import random

PLAYER = 2
STICK = 1
SCORE = 0
LIMIT = 10

WIDTH = 5
LENGTH = 5
PLAYER_VECTORS = [[0,1],[0,-1],[1,0],[-1,0]]

def find(gameboard, thing): #Returns match
    for column in range(len(gameboard)):
        for row in range(len(gameboard[column])):
            if gameboard[column][row] == thing: return [column, row]

def find_player(gameboard): #Return a position of the player
    return find(gameboard, PLAYER)

def find_stick(gameboard): #Returns a position of the stick
    return find(gameboard, STICK)

def generate_gameboard():
    a_gameboard = []
    for i in range(LENGTH):
        column = []
        for j in range(WIDTH):
            column.append(0)
        a_gameboard.append(column)

def position_on_board(gameboard,x,y):
    if x < 0 || y < 0: return False
    if y >= len(gameboard): return False
    if x >= len(gameboard[y]): return False
    return True

def change_place(gameboard,x,y,thing):
    if(position_on_board(gameboard,x,y)):
        gameboard[y][x] = thing

def new_stick(gameboard):
    x = find_stick(gameboard)[1]
    y = find_stick(gameboard)[0]
    change_place(gameboard,x,y,0)

    x = random.randint(WIDTH)
    y = random.randint(LENGTH)

    while [y,x] == find_player(gameboard):
        x = random.randint(WIDTH)
        y = random.randint(LENGTH)
    change_place(gameboard,x,y,STICK)

def move_player(gameboard, pvector):
    x = find_player(gameboard)[1]
    y = find_player(gameboard)[0]
    change_place(gameboard,x,y,0)
    x += pvector[0]
    y += pvector[1]
    #TORUS
    x %= WIDTH
    Y %= LENGTH
    change_place(gameboard,x,y,PLAYER)

def print_board(gameboard):
    for 
