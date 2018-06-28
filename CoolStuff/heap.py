class binaryheap:
    class Node:
        def __init__(self, data, weight):
            self.data = data
            self.weight = weight
    def __init__(self, max = True):
        self.heap = []
        self.max = max

    def addHelp(self, aNode):
        self.heap.append(aNode)
        self.heapifyUp(len(self.heap)-1)

    def add(self, data, weight):
        node = self.Node(data, weight)
        self.addHelp(node)

    def pop(self):
        if(len(self.heap) == 0): return
        if(len(self.heap) == 1):
            return self.heap.pop()
        self.swap(0, len(self.heap)-1)
        root = self.heap.pop()
        self.heapifyDown(0)
        return root

    def heapifyUp(self, currIndex):
        if(currIndex == 0): return
        if(self.priorityGreater(currIndex, self.parent(currIndex))):
            self.swap(currIndex, self.parent(currIndex))
            self.heapifyUp(self.parent(currIndex))

    def heapifyDown(self, headIndex):
        #Check if index has children
        right = self.right_child(headIndex)
        left = self.left_child(headIndex)
        if(headIndex >= len(self.heap)-1): return #We are done
        if(left > len(self.heap)-1):
            #Left child does not exist
            return
        if(self.right_child(headIndex) > len(self.heap)-1):
            #Only left child
            if(self.priorityGreater(left, headIndex)):
                self.swap(headIndex, left)
                self.heapifyDown(left)
            else: return #Else we are done because it is in right spot
        else:
            if(self.priorityGreater(left, right)):
                # Go left
                if(self.priorityGreater(left, headIndex)):
                    #Left child is the biggest child and we swap
                    self.swap(headIndex, left)
                    self.heapifyDown(left)
                else: return # We are done, the bigger child is too small to swap
            else:
                # Go right
                if(self.priorityGreater(right, headIndex)):
                    #Left child is the biggest child and we swap
                    self.swap(headIndex, right)
                    self.heapifyDown(right)
                else: return # We are done, the bigger child is too small to swap
    #Helper
    
    def right_child(self,i):
        return 2*i+2
    def left_child(self,i):
        return 2*i+1
    def parent(self,i):
        return (i-1)//2
    def swap(self, i,j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]
    def priorityGreater(self,i,j):
        I = self.heap[i]
        J = self.heap[j]
        return (self.max and (I.data > J.data)) or (not self.max and(I.data < J.data))

    def printdata(self):
        i = 0
        for item in self.heap:
            print(("root:\t" if i == 0 else ("left of " + str(self.parent(i))) if i % 2 == 1 else ("right of " + str(self.parent(i))))+ "\t"+str(item.data))
            i += 1
