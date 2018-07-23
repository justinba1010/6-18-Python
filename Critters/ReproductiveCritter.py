from Critter import Critter
import random
class ReproductiveCritter(Critter):
    def __init__(self,x,y,hunger):
        Critter.__init__(self,x,y,0)
        self.char = "R"
    def update(self):
        Critter.update(self)
        self.hunger = 0
    def collision(self, othercritter):
        if(self.x == othercritter.x and self.y == othercritter.y):
            newCritter = Critter(self.x,self.y,0)
            self.vector, othercritter.vector, newCritter.vector = self.__generate3Vectors()
            return newCritter
    def __generate3Vectors(self):
        x = y = z = 0
        while(x == y or y == z or x == z):
            x = [random.randint(-2,2), random.randint(-2,2)]
            y = [random.randint(-2,2), random.randint(-2,2)]
            z = [random.randint(-2,2), random.randint(-2,2)]
        return x,y,z
