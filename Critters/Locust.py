from Critter import Critter
import random

class Locust(Critter):
    def __init__(self, x, y, hunger):
        Critter.__init__(self, x, y, hunger)
        self.vector = [0,0]
        while(self.vector[0] + self.vector[1] < 3 or self.vector[0] == 0 or self.vector[1] == 0):
            self.vector = [random.randint(-4,4), random.randint(-4,4)]
        self.char = "L"
