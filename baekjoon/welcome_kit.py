# baekjoon 30802

from sys import stdin

N = int(stdin.readline())

size_counts = stdin.readline().split(" ")
size_count = []
for i in range(6):
    size_count.append(int(size_counts[i]))

order_limits = stdin.readline().split(" ")
shirts_limit = int(order_limits[0])
pen_limit = int(order_limits[1])
shirts_order = 0
for count in size_count:
    if count > 0:
        shirts_order = shirts_order + int((count-1) / shirts_limit) + 1
print(shirts_order)
print(int(N / pen_limit), N % pen_limit)
