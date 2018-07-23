def atoi(string):
    i = 0
    if(len(string) == 0): return 0
    if(string[0] == '-' or string[0] == '+'):
        i += 1
    while(i < len(string) and string[i] in ['0','1','2','3','4','5','6','7','8','9']):
        i += 1
    if(i == 0): return 0
    return int(string[:i])
