import random
l = []
k = 1000
for i in range(k):
    x = random.randint(-(2**31),2**31-1)
    l.append(x)
    print(x)

print()
print()
l.sort()
for j in l:
    print j
