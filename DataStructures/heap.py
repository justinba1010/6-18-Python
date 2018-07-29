import time
import random;

class Heap:
    def __init__(self):
        self.heapArray = [None]
        self.size = 0
    def add(self, value):
        self.heapArray.append(None)
        self.heapArray[self.size + 1] = value
        self.size += 1
        self.heapifyUp(self.size)
    def remove(self):
        if(self.size == 0): return None
        self.heapArray[1], self.heapArray[self.size] = self.heapArray[self.size], self.heapArray[1]
        self.size -= 1
        self.heapifyDown()
        r = self.heapArray.pop(self.size + 1)
        return r

    def heapifyUp(self, current):
        while(current > 1):
            parentOfCurrent = self.parent(current)
            if(self.heapArray[current] > self.heapArray[parentOfCurrent]):
                self.heapArray[current], self.heapArray[parentOfCurrent] = self.heapArray[parentOfCurrent], self.heapArray[current]
                current = parentOfCurrent
            else:
                return
    def heapifyDown(self):
        current = 1
        while(current < self.size):
            right = self.right(current)
            left = self.left(current)
            if(self.size >= right):
                if(self.heapArray[left] > self.heapArray[right]):
                    #left is bigger than right
                    if(self.heapArray[left] > self.heapArray[current]):
                        self.heapArray[left], self.heapArray[current] = self.heapArray[current], self.heapArray[left]
                        current = left
                    else: return
                else:
                    #right is bigger or equal to left
                    if(self.heapArray[right] > self.heapArray[current]):
                        self.heapArray[right], self.heapArray[current] = self.heapArray[current], self.heapArray[right]
                        current = right
                    else: return
                pass
            elif(self.size >= left):
                if(self.heapArray[left] > self.heapArray[current]):
                    self.heapArray[left], self.heapArray[current] = self.heapArray[current], self.heapArray[left]
                return
            else:
                #It has no kids
                return
    def parent(self, n):
        return n//2
    def left(self, n):
        return n*2
    def right(self, n):
        return self.left(n)+1

timestamp1 = time.time()*1000
x = A.remove()
while(x != None):
    x = A.remove()
timestamp2 = time.time()*1000
print("Heap Sort took: %d" % (timestamp2-timestamp1))


timestamp1 = time.time()*1000
swapSort(Array)
timestamp2 = time.time()*1000
print("Swap Sort took: %d" % (timestamp2-timestamp1))
