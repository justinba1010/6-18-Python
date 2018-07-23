from Critter import *
from HungryCritter import *
from ReproductiveCritter import *
import random
class CritterCollector:
    XRANGE = [0,15]
    YRANGE = [0,15]
    CRITTERS = [Critter,HungryCritter,ReproductiveCritter]
    CHANCEOFCRITTERSPAWN = .625
    def __init__(self):
        self.critters = []
    def update(self):
        if(random.random() < self.CHANCEOFCRITTERSPAWN):
            self.critters.append(self.CRITTERS[random.randint(0,len(self.CRITTERS)-1)](random.randint(self.XRANGE[0],self.XRANGE[1]),random.randint(self.YRANGE[0],self.YRANGE[1]),0))
        for i in range(len(self.critters)):
            for j in range(i+1, len(self.critters)):
                newcrittermaybe = self.critters[i].collision(self.critters[j])
                if(newcrittermaybe):
                    self.critters.append(newcrittermaybe)
        for critter in self.critters:
            critter.update()
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
