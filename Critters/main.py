import time
from CritterCollector import *

seconds = int(input("How much time would you like to run this automaton for? "))

interval = 1#1 second intervals

next = time.time()
endtime = time.time()+seconds

critters = CritterCollector()

while(time.time() <= endtime):
    if(next < time.time()):
        critters.update()
        critters.print()
        print("\n"*10)
        next += interval
