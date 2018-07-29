import random

class Critter:
    HUNGER_THRESHOLD = 15
    XRANGE = [0,20]
    YRANGE = [0,20]
    def __init__(self, x, y, hunger):
        self.x = x
        self.y = y
        self.death = False
        self.hunger = hunger
        self.power = random.random()
        self.vector = [0,0]
        while(self.vector == [0,0]):
            self.vector = [random.randint(-1,1), random.randint(-1,1)]
        self.char = chr(0x26D2)
    def die(self):
        self.death = True
    def hungry(self):
        if(self.hunger >= self.HUNGER_THRESHOLD):
            print("Death by hunger")
            self.die()
    def update(self):
        self.hunger += 1
        self.move(self.vector)
        self.hungry()
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
            print("Eaten")
            if(self.hunger > othercritter.hunger):
                #The first critter eats the second
                self.hunger = 0
                othercritter.die()
            elif(self.hunger < othercritter.hunger):
                #The second critter eats the first
                othercritter.hunger = 0
                self.die()
            else:
                #The more powerful critter eats the other
                if(self.power > othercritter.power):
                    self.hunger = 0
                    othercritter.die()
                else:
                    othercritter.hunger = 0
                    self.die()
    def string(self):
        return self.char
