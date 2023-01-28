# Five Six
# 2864

from sys import stdin
import re

# 최소 - 최대만 고려하면 됨
# 최소 : 싹다 5
# 최대 : 싹다 6
# 총 6가지 숫자만 나오게 됨 (A, B 원본, A 5, B 5, A 6, B 6) -> 이중에서는 6 - 5로 교차해서 진행

# 5인 경우, 6인 경우 구분하지 않는 것이 좋을수도?
# 5555 6666 -> 4C2만큼의 가능성 (12가지)

numbers = stdin.readline().strip().split(" ")
A = numbers[0]
B = numbers[1]

A_max = list(A)
A_min = list(A)
B_max = list(B)
B_min = list(B)

finder = re.compile('[5-6]+')

for one in re.finditer(finder, A):
    start_idx = -1
    last_idx = -1
    for pos in one.span():
        if start_idx == -1:
            start_idx = pos
        elif last_idx == -1:
            last_idx = pos

    for idx in range(start_idx, last_idx):
        A_max[idx] = '6'
        A_min[idx] = '5'

for one in re.finditer(finder, B):
    start_idx = -1
    last_idx = -1
    for pos in one.span():
        if start_idx == -1:
            start_idx = pos
        elif last_idx == -1:
            last_idx = pos
    for idx in range(start_idx, last_idx):
        B_max[idx] = '6'
        B_min[idx] = '5'

num_min = 3000000
num_max = -1

a = [int(''.join(A_max)), int(''.join(A_min))]
b = [int(''.join(B_max)), int(''.join(B_min))]

for i in a:
    for j in b:
        num_min = min(num_min, abs(int(i)+int(j)))
        num_max = max(num_max, abs(int(i)+int(j)))

print(num_min, num_max)
