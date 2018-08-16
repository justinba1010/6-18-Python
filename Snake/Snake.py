import random

class Snake:
    def __init__(self, size):
        self.limit = size
        self.snake = [[random.randint(0,self.limit - 1), random.randint(0,self.limit - 1)]]
        self.apple = [random.randint(0,self.limit - 1), random.randint(0,self.limit - 1)]
        while self.apple == self.snake:
            self.apple = [random.randint(0,self.limit - 1), random.randint(0,self.limit - 1)]
        self.score = 0
        self.over = False
    def makeMove(self, direction):
        finalsquare = [0,0]
        finalsquare[0] = self.snake[-1][0]
        finalsquare[1] = self.snake[-1][1]
        if(direction == 0):
            finalsquare[1] += 1
        if(direction == 1):
            finalsquare[0] -= 1
        if(direction == 2):
            finalsquare[1] -= 1
        if(direction == 3):
            finalsquare[0] += 1
        #Make it a torus
        finalsquare[0] = finalsquare[0] % self.limit
        finalsquare[1] = finalsquare[1] % self.limit
        #Check if that square is already part of the snake
        if finalsquare in self.snake:
            #It is in the snake
            self.over = True
            return
        #Check if we got the apple
        if finalsquare == self.apple:
            self.score += 1
            self.apple = [random.randint(0,self.limit - 1), random.randint(0,self.limit - 1)]
        else: self.snake.pop(0)
        self.snake.append(finalsquare)
    def toString(self):
        s = ""
        for i in range(self.limit):
            for j in range(self.limit):
                if([i,j] in self.snake):
                    s += unichr(0x25A1)
                elif([i,j] == self.apple):
                    s += unichr(0x2299)
                else:
                    s += " "
            if(i != self.limit - 1): s += "\n"
        return s
