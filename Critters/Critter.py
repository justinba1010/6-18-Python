import random

class Critter:
    HUNGER_THRESHOLD = 10
    XRANGE = [0,15]
    YRANGE = [0,15]
    def __init__(self, x, y, hunger):
        self.x = x
        self.y = y
        self.hunger = 0
        self.power = random.random()
        self.vector = [random.randint(-2,2), random.randint(-2,2)]
        self.char = 'X'
    def update(self):
        self.hunger += 1
        self.move(self.vector)
    def move(self, vector):
        #Check if X vector keeps the critter in bounds, if not make the critter bounce off the wall
        if(self.x + vector[0] < self.XRANGE[0] or self.x + vector[0] > self.XRANGE[1]):
            vector[0] *= -1
        #Check if Y vector keeps the critter in bounds, if not make the critter bounce off the wall
        if(self.y + vector[1] < self.YRANGE[0] or self.y + vector[1] > self.YRANGE[1]):
            vector[1] *= -1
        self.x += vector[0]
        self.y += vector[1]
    def collision(self, othercritter):
        #Check if they actually hit each other
        if(self.x == othercritter.x and self.y == othercritter.y):
            #Check if other critter is a ReproductiveCritter
            if(str(type(othercritter)) ==  "<class 'ReproductiveCritter.ReproductiveCritter'>"):
                othercritter.collision(self)
                return
            if(self.hunger > othercritter.hunger):
                #The first critter eats the second
                self.hunger = 0
                del(othercritter)
            elif(self.hunger < othercritter.hunger):
                #The second critter eats the first
                othercritter.hunger = 0
                del(self)
            else:
                #The more powerful critter eats the other
                if(self.power > othercritter.power):
                    self.hunger = 0
                    del(othercritter)
                else:
                    othercritter.hunger = 0
                    del(self)
    def string(self):
        return self.char
