class BinaryTrie:
    class Node:
        def __init__(self, value = False):
            self.value = value
            self.one = None
            self.zero = None
    def __init__(self):
        self.root = self.Node(False) #define root
    def push(self, value):
        self.__push(self.root, value+2)
    def __push(self, node, value):
        if value == 0:
            node.value = True
            return
        end = value % 2
        value = value >> 1
        if(end == 0):
            if(node.zero):
                pass
            else:
                node.zero = self.Node()
            self.__push(node.zero, value)
        if(end == 1):
            if(node.one):
                pass
            else:
                node.one = self.Node()
            self.__push(node.one, value)
    def remove(self, value):
        self.__remove(self.root, value+2)
    def __remove(self, node, value):
        if value == 0:
            node.value = False
            return
        end = value % 2
        value = value >> 1
        if(end == 0):
            if(node.zero):
                pass
            else:
                node.zero = Node()
            self.__remove(node.zero, value)
        if(end == 1):
            if(node.one):
                pass
            else:
                node.one = Node()
            self.__remove(node.one, value)
    def search(self, value):
        self.__search(self.root, value+2)
    def __search(self, node, value):
        if value == 0:
            return node.value
        end = value % 2
        value = value >> 1
        if(end == 0):
            if(node.zero):
                pass
            else:
                node.zero = Node()
            self.__search(node.zero, value)
        if(end == 1):
            if(node.one):
                pass
            else:
                node.one = Node()
            self.__search(node.one, value)
