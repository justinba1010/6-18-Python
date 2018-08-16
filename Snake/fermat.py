for a in range(1,500):
    for b in range(1,500):
        for c in range(1,500):
            d3 = a**3 + b**3 + c**3
            d = d3**(1./3)
            if(abs(d - d3) < 0.005):
                print(a)
                print(b)
                print(c)
                print(d)
                print("")
