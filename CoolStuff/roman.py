keyIndex = [1,5,10,50,100,500,1000]
romans =    {   1:'I',
                5:'V',
                10:'X',
                50:'L',
                100:'C',
                500:'D',
                1000:'M'
            }
def roman(aNumber):
    romannum = ""
    for i in range(-len(keyIndex)+1,1):
        while(aNumber > keyIndex[i]):
            romannum += romans[keyIndex[i]]
            aNumber -= keyIndex[i]
        for num in keyIndex[:i]:
            while(aNumber > keyIndex[i] - num):
                romannum = romans[num] + romannum + romans[keyIndex[i]]
                aNumber -= keyIndex[i] - num
    return romannum
