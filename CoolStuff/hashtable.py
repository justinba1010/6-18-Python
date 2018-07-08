import hashlib

bits = 12

class HashTable:
    class Node:
        def __init__(self, level):
            self.byte = 0
            self.children = []
            self.level = level
    class FinalChild:
        def __init__(self, data):
            self.data = data
    def __init__(self):
        self.root = Node(0)
    def add(self, data):
        self.addRecur(data,md5(data))
    def addRecur(self, data, hash):
        value = hash % 2**(bits-)



def md5(string):
    return int(hashlib.md5(string.encode),16) % 4096
