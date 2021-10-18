# baekjoon #1032
# Command Prompt
from sys import stdin

n = int(stdin.readline())
commands = [stdin.readline() for i in range(n)]

L = len(commands[0])
result = ""
for i in range(0, L):
    flag = True
    # 문자열 글자별로 검사, 하나라도 어긋나는 단어가 있다면 바로 ?
    for j in range(1, n):
        if commands[j][i] != commands[0][i]:
            flag = False
            break
    if flag:
        result = result+commands[0][i]
    else:
        result = result+"?"
print(result)
