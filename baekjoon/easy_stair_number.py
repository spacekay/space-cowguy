# baekjoon #2156
# Easy Stair Number

from sys import stdin

n = int(stdin.readline())

arr = [[0 for _ in range(10)] for _ in range(n)]
for i in range(1, 11):
    arr[1][i] = 1

# 어떤 수를 만들기 위해서는 대체로 이전에 두가지 수를 사용할 수 있음

for i in range(2, n+1):
    for j in range(0, 11):
        

print(arr[-1])
