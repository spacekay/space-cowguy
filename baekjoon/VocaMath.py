# Voca Math
# 1339

from sys import stdin

n = int(stdin.readline())

word_list = []

# 최대 열 개의 단어를 받을 수 있음

for j in range(n):
    word_list.append(list(stdin.readline().rstrip())[::-1])

word_list.sort(key=lambda x: -len(x))

first = word_list[0]

first_l = len(first)

number_used = {}
letters = set()

for i in range(0, first_l):
    for j in range(n):
        now = word_list[j]
        if len(now) > i:
            if not now[i] in letters:
                number_used[now[i]] = int(pow(10, i))
                letters.add(now[i])
            else:
                number_used[now[i]] = number_used[now[i]] + int(pow(10, i))

number_used = {k: v for k, v in sorted(number_used.items(), key=lambda item: -item[1])}

sum_all = 0
number_now = 9

for letter in number_used:
    for j in range(n):
        word_list[j] = ''.join(word_list[j])
        word_list[j] = word_list[j].replace(letter, str(number_now))
    number_now = number_now - 1

for word in word_list:
    sum_all = sum_all + int(word[::-1])

print(sum_all)

# 둘 중에 자릿수가 긴거부터 해서..
# 앞자리 알파벳을 9로 바꾸어야함. 그 다음은 그 다음 문자..

# 단순히 10개 중 숫자 1개의 자릿수만으로는 총합을 예상할 수 없음
# 따라서 각 알파벳의 자릿수를 기반으로 어떤 자리에서 얼마나 많이 등장했는지 (총합에 영향을 얼마나 끼치는지) 를 파악하여
# 총합 기여도가 높은 알파벳부터 해당하는 숫자를 부여하도록 함


