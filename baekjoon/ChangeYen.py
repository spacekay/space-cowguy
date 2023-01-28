# Change Yen
# 5585

from sys import stdin

change = 1000 - int(stdin.readline())

coin_count = 0

while change > 0:
    if change >= 500:
        change = change - 500
        coin_count = coin_count + 1
    elif change >= 100:
        change = change - 100
        coin_count = coin_count + 1
    elif change >= 50:
        change = change - 50
        coin_count = coin_count + 1
    elif change >= 10:
        change = change - 10
        coin_count = coin_count + 1
    elif change >= 5:
        change = change - 5
        coin_count = coin_count + 1
    elif change >= 1:
        coin_count = coin_count + change
        change = 0

print(coin_count)
