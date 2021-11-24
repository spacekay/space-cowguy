# Binary Number
# 3460

from sys import stdin

T = int(stdin.readline())

for i in range(T):
    n = int(stdin.readline())
    bin_n = bin(n)
    str_n = str(bin_n)[2:]
    # print(str_n)
    result = ""
    for j in range(len(str_n)):
        index = len(str_n)-j-1
        if str_n[index] == '1':
            result = result+str(j)+" "
    result = result[0:-1]
    print(result)
    
