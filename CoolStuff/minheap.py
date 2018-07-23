class MinHeap:
    class __Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
    def __init__(self):
        self.heap = []
    def push(self, key, value):
        self.heap.append(self.__Node(key, value))
        self.heapifyUp(len(self.heap)-1)
    def pop(self):
        i = len(self.heap) - 1
        if(i < 0): return None
        self.swap(0,i)
        temp = self.heap[i].value
        self.heap.pop()
        self.heapifyDown(0)
        return temp
    def isEmpty(self):
        return len(self.heap) <= 0
    def parent(self, i):
        #Indexing at 0
        return (i-1)//2
    def left(self, i):
        return 2*i+1
    def right(self, i):
        return 2*i+2
    def heapifyUp(self, i):
        if(i <= 0): return
        parent = self.parent(i)
        if(self.heap[i].key < self.heap[parent].key):
            self.swap(i, parent)
            self.heapifyUp(parent)
    def inHeap(self, i):
        return len(self.heap) > i
    def heapifyDown(self, i):
        right = self.right(i)
        left = self.left(i)
        if(self.inHeap(left)):
            if(self.inHeap(right)):
                if(self.heap[left].key < self.heap[right]):
                    #go left
                    if(self.heap[left].key < self.heap[i].key):
                        self.swap(i, left)
                        self.heapifyDown(left)
                else:
                    if(self.heap[right].key < self.heap[i].key):
                        self.swap(i, right)
                        self.heapifyDown(right)
            else:
                if(self.heap[left].key < self.heap[i].key):
                    self.swap(i, left)
                    self.heapifyDown(left)

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]
    def printdata(self):
        i = 0
        while(i < len(self.heap)):
            print(str(i) + ":\t\t" + str(self.heap[i].key))
            i += 1

A.push(0,0)
A.printdata()

while(not A.isEmpty()):
    B = A.pop()
    A.printdata()
    print(B)
