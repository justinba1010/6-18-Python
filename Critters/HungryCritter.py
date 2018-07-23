from Critter import Critter
class HungryCritter(Critter):
    def __init__(self,x,y,hunger):
        Critter.__init__(self,x,y,1000)
        self.char = "H"
    def update(self):
        Critter.update(self)
        self.hunger = 1000
