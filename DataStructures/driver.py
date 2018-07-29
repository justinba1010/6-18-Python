from Stack import Stack
from Queue import Queue

stack = Stack()
queue = Queue()

for i in range(50):
    stack.push(i)
    queue.enqueue(i)

print("Printing stack")
popped = stack.pop()
while(popped != None):
    print(popped)
    popped = stack.pop()

print("Printing queue")
dequeued = queue.dequeue()
while(dequeued != None):
    print(dequeued)
    dequeued = queue.dequeue()
