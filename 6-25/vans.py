import math
vans = ["15p","15pe","12p","12pe","8p"]
days = [179.99,199.99,169.99,179.99,159.99]
week = [1199.99,1299.99,999.99,1199.99,999.99]
per10 = [0,-99.97,0,0,0]

tax = 0.06625

dsf = 5
vlf = 7


van = raw_input("Which van would you like? ")
vannum = vans.index(van)

day = int(input("How many days: "))



def pretax(num,d):
    weeks = d // 7
    tens = d % 10
    adays = d % 7
    return days[num]*adays + week[num]*weeks - per10[num]*tens

def vlffee(num,d):
    x = d//5
    return vlf*(x + 1 if d % 5 != 0 else x)

def dsffee(num,d):
    return dsf*d



ptax = math.ceil((pretax(vannum,day))*100)/100.
t = math.ceil((ptax*tax)*100)/100.
v = math.ceil((vlffee(vannum,day))*100)/100.
d = math.ceil((dsffee(vannum,day)*100))/100.


print("Pretax Rate: \t%.2f" % (ptax))
print("Tax: \t\t%.2f" % (t))
print("Sub-Total: \t%.2f" %(ptax+t))
print("VLF Fee: \t%.2f"%(v))
print("DSF Fee: \t%.2f"%(d))
print("Total: \t\t%.2f"%(ptax+tax+v+d))
