#Conditionals

true_and_true = True and True; #=True
true_and_false = True and False;#=False
false_and_true = False and True;#=False
false_and_false = False and False;#=False

true_or_true = True or True; #=True
true_or_false = True or False;#=True
false_or_true = False or True;#=True
false_or_false = False or False;#=False

true_xor_true = True ^ True; #=False
true_xor_false = True ^ False;#=True
false_xor_true = False ^ True;#=True
false_xor_false = False ^ False;#=False


if 7 == 6:
    #do this
    if 6 >= 6:
        #do this
        pass
    elif 5 < 4:
        #do this
        pass
    else:
        #do this
        pass
else:
    if 4==4 and 3 == 3:
        #do this
        pass
    else:
        print("We didn't prepare for all possibilities.")

#pass is to tell the computer we don't want to do anything
