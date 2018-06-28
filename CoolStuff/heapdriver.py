from heap import binaryheap

heap = binaryheap()

heap.add(1,1)
heap.add(2,2)
heap.add(3,3)
heap.add(4,4)
heap.add(5,5)

while(len(heap.heap) > 0):
    print(heap.pop().data)

minheap = binaryheap()
minheap.add(5,5)
minheap.add(4,4)
minheap.add(3,3)
minheap.add(2,2)
minheap.add(1,1)

while(len(minheap.heap) > 0):
    print(minheap.pop().data)
