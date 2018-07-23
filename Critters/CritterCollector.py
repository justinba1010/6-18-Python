from Critter import *
from HungryCritter import *
from ReproductiveCritter import *
from Locust import *
import math
import random
class CritterCollector:
    Z = 10
    XRANGE = [0,Z]
    YRANGE = [0,Z]
    COEFFICIENT = 1
    CRITTERS = [Critter, HungryCritter, ReproductiveCritter, Locust]
    CHANCEOFCRITTERSPAWN = .625
    def __init__(self):
        self.critters = []
    def update(self):
        if(self.Z < math.pow(len(self.critters), .5) + 5):
            self.Z = int(math.pow(len(self.critters), .5) + 8)
            self.XRANGE = [0,self.Z]
            self.YRANGE = [0,self.Z]
        Critter.XRANGE = self.XRANGE
        Critter.YRANGE = self.YRANGE
        if(random.random() < self.CHANCEOFCRITTERSPAWN):
            self.critters.append(self.CRITTERS[random.randint(0,len(self.CRITTERS)-1)](random.randint(self.XRANGE[0],self.XRANGE[1]),random.randint(self.YRANGE[0],self.YRANGE[1]),0))
        for i in range(len(self.critters)):
            for j in range(i+1, len(self.critters)):
                newcrittermaybe = self.critters[i].collision(self.critters[j])
                if(newcrittermaybe):
                    print("New one")
                    self.critters.append(newcrittermaybe)
        for i in range(len(self.critters)):
            if(i >= len(self.critters)): return
            self.critters[i].update()
            if(self.critters[i].death):
                del(self.critters[i])
                i -= 1
    def print(self):
        arr = [[0 for x in range(self.YRANGE[0], self.YRANGE[1]+1)] for y in range(self.XRANGE[0], self.XRANGE[1]+1)]
        for critter in self.critters:
            arr[critter.y][critter.x] = critter.string()
        for y in range(self.YRANGE[0], self.YRANGE[1] + 1):
            for x in range(self.XRANGE[0], self.XRANGE[1] + 1):
                print("|", end="")
                if arr[x][y] == 0:
                    print(" ", end = "")
                else:
                    print(arr[x][y], end = "")
            print("")
