size = 100000
center = [size//2,size//2]
totalpins = 0
incircle = 0
import random

while True:
    x = random.randint(0,size-1)
    y = random.randint(0,size-1)
    if((size//2)**2 >= (x-center[0])**2 + (y-center[1])**2):
        #point is in circle
        incircle += 1
    totalpins += 1
    pi = (incircle)*4.0/totalpins
    print(pi)
