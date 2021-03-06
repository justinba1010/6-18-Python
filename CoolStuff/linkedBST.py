class linkedBST:
    class Node:
        def __init__(self, data):
            self.data = data
            self.right = None
            self.left = None
    def __init__(self):
        self.root = None

    def add(self, data):
        #Is there a root?
        if self.root == None:
            self.root = self.Node(data)
            return True
        self.__add(self.root, data)

    def __add(self, currNode, data):
        #Which way?
        if(data > currNode.data):
            #Right
            if(currNode.right != None):
                self.__add(currNode.right, data)
            else:
                #This is a leaf
                currNode.right = self.Node(data)
        elif(data < currNode.data):
            if(currNode.left != None):
                self.__add(currNode.left, data)
            else:
                currNode.left = self.Node(data)
        else:
            return False
        return True

    def str(self):
        self.__str(self.root)
    def __str(self, currNode):
        print(currNode.data)
        if(currNode.right): __str(self, currNode.right)
        if(currNode.left): __str(self,currNode.left)

    def search(self,data):
        return self.__search(self.root, None, data)[0].data
    def __search(self, currNode, parent, data):
        if currNode == None: return None
        if data == currNode.data: return (currNode, parent)

        if data > currNode.data: return self.__search(currNode.right, currNode, data)
        else: return self.__search(currNode.left, currNode, data)

    def remove(self, data):
        node = self.__search(self.root, None, data)
        if(node):
            child = node[0]
            parent = node[1]
            if(child.right != None and child.left != None):
                pass
                #Both children exist
    def __maxNode(self,currNode):
        if(currNode.right):
            return __maxNode(self,currNode.right)
        else:
            return currNode
    def preorder(self):
        self.__preorder(self.root,0)
    def postorder(self):
        self.__preorder(self.root,2)
    def inorder(self):
        self.__preorder(self.root,1)

    def __preorder(self,currNode,x):
        if(currNode):
            if x == 0: print(currNode.data)
            self.__preorder(self,currNode.left)
            if x == 1: print(currNode.data)
            self.__preorder(self,currNode.right)
            if x == 2: print(currNode.data)
