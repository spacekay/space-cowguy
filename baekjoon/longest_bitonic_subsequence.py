# baekjoon 11054
# Longest Bitonic Subsequence
from sys import stdin

# 초기화와 index 범위 설정의 중요성
n = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))
arr.append(0)

left = [1 for _ in range(n+1)]
right = [1 for _ in range(n+1)]

for i in range(0, n):
    for j in range(i):
        # arr[j]를 포함한 기준으로 앞뒤를 조사
        if arr[j] < arr[i]:
            left[i] = max(left[i], left[j]+1)

for i in range(n-1, -1, -1):
    for j in range(i, n):
        # arr[j]를 포함한 기준으로 앞뒤를 조사
        if arr[j] < arr[i]:
            right[i] = max(right[i], right[j]+1)

max_result = [1 for _ in range(n)]
for i in range(n):
    if arr[i] != arr[i+1]:
        # 중복되는 값 1만 빼줌
        max_result[i] = left[i]+right[i]-1
    else:
        max_result[i] = max(left[i], right[i])

print(max(max_result))
