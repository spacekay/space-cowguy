# baekjoon 2565
# Electric Code
from sys import stdin

n = int(stdin.readline())
inputs = [list(map(int, stdin.readline().split())) for _ in range(n)]
arr = [0 for _ in range(501)]
ans = [1 for _ in range(501)]

for i in range(n):
    arr[inputs[i][0]] = inputs[i][1]

for i in range(501):
    if arr[i] != 0:
        tmp = 1  # 자기 자신
        # i번째 전깃줄에 걸리지 않는 전깃줄 개수 세기
        for j in range(i):
            if arr[j] != 0 and arr[i] > arr[j]:
                # tmp : 살릴 수 있는 전깃줄 개수
                # 중간에 조건에 해당하지 않는 원소는 제외하려 길이를 측정함
                tmp = max(tmp, ans[j]+1)
                # j번째 전깃줄과 걸리지 않는 최대 전깃줄 개수에 나 자신을 더함
        ans[i] = tmp

print(n-max(ans))
