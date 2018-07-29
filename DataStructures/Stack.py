from LLNode import LLNode
class Stack:
    def __init__(self):
        self.head = None
    def push(self, value):
        newNode = LLNode(value)
        newNode.next = self.head
        self.head = newNode
    def pop(self):
        if(self.head == None):
            print("Stack is empty")
            return None
        data = self.head.data
        self.head = self.head.next
        return data
