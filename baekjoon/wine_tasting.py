# baekjoon #2156
# Wine Tasting

from sys import stdin

n = int(stdin.readline())
glasses = [int(stdin.readline()) for _ in range(n)]
max_wine = []

if n < 3:
    print(sum(glasses))
else:
    max_wine.append(glasses[0])
    max_wine.append(max_wine[0] + glasses[1])
    max_wine.append(max(glasses[0] + glasses[2], glasses[1] + glasses[2], glasses[1]+glasses[0]))

    for i in range(3, n):
        max_wine.append(max(glasses[i - 1] + glasses[i] + max_wine[i - 3], max_wine[i - 2] + glasses[i], max_wine[i - 1]))

    print(max_wine[-1])
