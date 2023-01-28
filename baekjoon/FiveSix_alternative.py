# Five Six
# 2864

from sys import stdin

numbers = stdin.readline().strip().split(" ")
A = numbers[0]
B = numbers[1]

num_min = int(A.replace('6', '5')) + int(B.replace('6', '5'))
num_max = int(A.replace('5', '6')) + int(B.replace('5', '6'))

print(num_min, num_max)
