# Treasure 1026

from sys import stdin

n = int(stdin.readline())

arr_a = list(map(int, stdin.readline().split()))
arr_b = list(map(int, stdin.readline().split()))

# B에 있는 수가 몇 번째로 큰 수인지 확인
# A의 가장 큰 수 - B의 가장 작은 수 순으로 곱해줌
arr_b_new = [[arr_b[i], i] for i in range(n)]

# 곧바로 arr_b로 진행해도 가능은 함
arr_a.sort()
arr_b_new.sort(reverse=True)

s = 0
for i in range(n):
    s = s + arr_b[arr_b_new[i][1]] * arr_a[i]

print(s)
