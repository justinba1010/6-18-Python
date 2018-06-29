class Stack:
    class __Node:
        def __init__(self, data):
            self.data = data
            self.next = None
    def __init__(self):
        self.head = None

    def push(self, data):
        node = self.__Node(data)
        node.next = self.head
        self.head = node

    def pop(self):
        if(self.head == None): return
        data = self.head.data
        self.head = self.head.next
        return data
