from TNode import TNode

class twotree:
    def __init__(self):
        self.root = None

    def insert(self, key, value):
        newNode = TNode(key, value)
        if(self.root == None):
            self.root = newNode
            return
        self.__insert(self.root, key, value)

    def findMin(self, node):
        curr = node
        while(curr.left):
            curr = curr.left
        return curr

    def __helpremove(self, node):
        if(node.right == None and node.left == None):
            #we have no kids
            return None
        if(node.right and node.left):
            minNode = self.findMin(node.right)
            self.remove(minNode.key)
            minNode.right = node.right
            minNode.left = node.left
            return minNode
        if(node.right == None):
            return node.left
        return node.right

    def remove(self, key):
        if(self.root.key == key):
            self.root = self.__helpremove(self.root)
            return
        self.__remove(self.root, key)

    def __remove(self, node, key):
        if(key < node.key):
            if(node.left.key == key):
                node.left = self.__helpremove(node.left)
            else:
                self.__remove(node.left, key)
        elif(key > node.key):
            if(node.right.key == key):
                node.right = self.__helpremove(node.right)
            else:
                self.__remove(node.right, key)
        else:
            print("Error")

    def __insert(self, node, key, value):
        if(key < node.key):
            #Left
            if(node.left == None):
                #There is no left child
                newNode = TNode(key, value)
                node.left = newNode
            else:
                self.__insert(node.left, key, value)
        elif(key > node.key):
            #Right
            if(node.right == None):
                #There is no right child
                newNode = TNode(key, value)
                node.right = newNode
            else:
                self.__insert(node.right, key, value)

    def preOrder(self):
        self.__preOrder(self.root)

    def __preOrder(self, node):
        if(node == None): return
        print(node.key, end=" ")
        print(node.value)
        self.__preOrder(node.left)
        self.__preOrder(node.right)

    def inOrder(self):
        self.__inOrder(self.root)

    def __inOrder(self, node):
        if(node == None): return
        self.__inOrder(node.left)
        print(node.key, end = " ")
        print(node.value)
        self.__inOrder(node.right)

    def postOrder(self):
        self.__postOrder(self.root)

    def __postOrder(self, node):
        if(node == None): return
        self.__postOrder(node.left)
        self.__postOrder(node.right)
        print(node.key, end = " ")
        print(node.value)

    def levelView(self):
        queue = []
        if(self.root):
            queue.append(self.root)
        while(len(queue) > 0):
            curr = queue.pop(0)
            if(curr.left): queue.append(curr.left)
            if(curr.right): queue.append(curr.right)
            print(curr.key) 

A = twotree()
"""import random
for i in range(50):
    A.insert(random.randint(-100,100), None)
"""

A.insert(4, None)
A.insert(2, None)
A.insert(1, None)
A.insert(3, None)
A.insert(6, None)
A.insert(5, None)
A.insert(7, None)
A.levelView()
