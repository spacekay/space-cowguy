# baekjoon #1912
# Continuous Sum

from sys import stdin

n = int(stdin.readline())
arr = list(map(int, stdin.readline().split()))

dp = [0 for _ in range(n)]
max_arr = [0 for _ in range(n)]
max_sum = dp[0] = arr[0]
flag = False

for i in range(1, n):
    # 먼저 이전까지의 연속합 + 현재 / 현재만 비교
    # (계속 연속합을 Reset하여 for문 한방에 끝낼 수 있음)
    dp[i] = max(arr[i], dp[i-1]+arr[i])
    # 새로 구한 현 시점에서의 합과 저장된 최대값을 비교
    max_sum = max(max_sum, dp[i])

print(max_sum)
