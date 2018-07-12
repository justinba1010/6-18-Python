class StringTrie:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.children = []
    def __init__(self):
        self.head = Node(None,None)
    def add(self, key, value):
        self.__add(self.head, key, value)
    def __add(self, Node, key, value):
        if(len(key) == 1):
            newNode = Node(key, value)
            Node.children.append(newNode)
            return
        for child in Node.children:
            if child.key == key[0]:
                self.__add(child, key[1:], value)
                return
        newNode = Node(key, value)
        Node.children.append(newNode)
        self.__add(newNode, key[1:], value)
    def find(self, key):
        return self.__find(self.head key)
    def __find(self, Node, key):
        if(len(key) == 0): return Node.value
        for child in Node.children:
            if child.key == key[0]:
                return self.__find(child, key[1:])
        return False
    def remove(self, key):
        pass
    
