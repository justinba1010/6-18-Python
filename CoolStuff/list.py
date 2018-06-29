class List:
    class __Node:
        def __init__(self, data):
            self.data = data
            self.next = None
    def __init__(self):
        self.head = None
        self.size = 0

    def add(self, data):
        node = Node(data)
        curr = self.head
        self.size += 1
        if(curr == None):
            self.head = node
            return
        while(curr.next != None):
            curr = curr.next
        curr.next = node

    def add_at(self, data, index):
        i = 0
        curr = self.head
        node = Node(data)
        self.size += 1
        if(curr == None):
            self.head = node
            return
        while(curr.next != None || i != index):
            curr = curr.next
            i += 1
        nextnext = curr.next.next
        curr.next = node
        node.next = nextnext

        #NOT DONE with add at or remove index
    def remove_index(self, index):
        i = 0
        curr = self.head
        while(curr.next != None || i != index):
            curr = curr.next
            i += 1
    def remove_item(self, data):
        pass
    
