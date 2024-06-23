# baekjoon 2531

from sys import stdin

N, d, k, c = stdin.readline().split(" ")
sushi_all = []
for i in range(int(N)):
    sushi_all.append(int(stdin.readline()))

sushi_max = 0
dish_count = int(k)
sushi_all_count = int(N)
sushi_coupon = int(c)

# 하나의 for 문으로 해결할 수 있도록 일정 구간의 리스트를 바로 셋으로 바꿔주기
for i in range(sushi_all_count):
    if i < sushi_all_count - dish_count:
        sushi_set = set(sushi_all[i:i+dish_count])
    else:
        sushi_set = set(sushi_all[i:])
        sushi_set.update(sushi_all[:i+dish_count-sushi_all_count])
    sushi_set.add(sushi_coupon)
    sushi_max = max(sushi_max, len(sushi_set))

print(sushi_max)

# 좀 더 빠르게 하려면 각 스시별 케이스를 고려하여 two pointer 를 사용하는 것도 방법
# 오늘은 워낙 오랜만의 몸풀기용이므로 일단은 머리를 식히자
