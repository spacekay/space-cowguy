# baekjoon #10844
# Easy Stair Number

from sys import stdin

n = int(stdin.readline())

arr = [[0 for _ in range(10)] for _ in range(n+2)]
for i in range(1, 10):
    arr[1][i] = 1

# 어떤 수를 만들기 위해서는 대체로 이전에 두가지 수를 사용할 수 있음

for i in range(2, n+1):
    for j in range(0, 10):
        if j == 0:
            arr[i][j] = arr[i-1][j+1]
        elif j == 9:
            arr[i][j] = arr[i-1][j-1]
        else:
            arr[i][j] = arr[i-1][j-1]+arr[i-1][j+1]

print(sum(arr[n]) % 1000000000)
