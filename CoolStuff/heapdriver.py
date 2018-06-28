from heap import binaryheap
import random
heap = binaryheap()

for i in range(10):
    x = random.randint(0,100)
    print(x)
    heap.add(x,x)

heap.printdata()

y = heap.pop()
while y != None:
    print(y.data)
    heap.printdata()
    y = heap.pop()
