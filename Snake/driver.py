from Snake import Snake
ourSnake = Snake(10)
print(ourSnake.toString())
while(not ourSnake.over):
    move = 5
    while(not (0 <= move < 4)):
        print("Please make a move: ")
        move = int(input())
    ourSnake.makeMove(move)
    print(ourSnake.toString())
