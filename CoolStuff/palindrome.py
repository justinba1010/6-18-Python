def palindrome(aString):
    #For odd aString
    highestsubstring = ""
    length = len(aString)
    for i in range(len(length)):
        z = startplace(aString, i)
        if len(z) > len(highestsubstring):
            highestsubstring = z
    return highestsubstring

def startplace(aString, index):
    substring = ""
    substring = substring ++ aString[index]
    for i in range(len(aString) - index):
        if(index + i >= len(aString) or index - i < 0): break
        lettera = aString[index+i]
        letterb = aString[index-i]
    return substring
