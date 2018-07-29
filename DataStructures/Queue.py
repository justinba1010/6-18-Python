from LLNode import LLNode

class Queue:
    def __init__(self):
        self.head = None
    def enqueue(self, value):
        newNode = LLNode(value)
        curr = self.head
        if(curr == None):
            self.head = newNode
            return
        while(curr.next != None):
            curr = curr.next
        curr.next = newNode
    def dequeue(self):
        if(self.head == None):
            print("Queue is empty")
            return None
        data = self.head.data
        self.head = self.head.next
        return data
