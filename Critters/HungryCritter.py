from Critter import Critter
class HungryCritter(Critter):
    def __init__(self,x,y,hunger):
        Critter.__init__(self,x,y,7)
        self.char = "H"
