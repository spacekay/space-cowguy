# 김종희

import numpy as np


def check_index(x, n):
    # index 범위를 벗어나는 경우를 보정하기 위한 함수
    if x < 0:
        x = x + n
    elif x >= n:
        x = x - n
    return x


def calculate_sum(x, n):
    # 가로
    each_sum = 0
    for i in range(n):
        each_sum = each_sum + x[0, i]
    else:
        print("가로방향 합 :", each_sum)
    # 세로
    each_sum = 0
    for i in range(n):
        each_sum = each_sum + x[i, 0]
    else:
        print("세로방향 합 :", each_sum)
    # 대각선
    each_sum = 0
    for i in range(n):
        each_sum = each_sum + x[i, i]
    else:
        print("대각선방향 합 :", each_sum)


def make_mabangjin_odd(n):
    a = np.zeros((n, n), int)
    # 시작점은 직접 정의
    x = 0
    y = int(n / 2)
    a[x, y] = 1
    for i in range(2, n ** 2 + 1):
        x = x - 1
        y = y + 1
        x = check_index(x, n)
        y = check_index(y, n)
        if a[x, y] != 0:
            # y는 원상복구, x는 이동 전보다도 한 칸 더 아래로
            x = x + 2
            y = y - 1
            x = check_index(x, n)
            y = check_index(y, n)
        # 모든 처리 끝난 후 현재의 i값을 대입
        a[x, y] = i
    # 가로, 세로, 대각선방향 총합
    calculate_sum(a, n)
    return a


def make_mabangjin_even(n):
    a = np.arange(1, n ** 2 + 1).reshape((n, n))
    b = np.arange(n ** 2, 0, -1).reshape((n, n))
    c = np.zeros((n, n), int)
    # 가독성 늘리기 위해 아래와 같이 변수 만들고 치환
    s = int(n / 4)
    c[:s, :s] = a[:s, :s]
    c[:s, 3 * s:] = a[:s, 3 * s:]
    c[3 * s:, :s] = a[3 * s:, :s]
    c[3 * s:, 3 * s:] = a[3 * s:, 3 * s:]
    c[s:3 * s, s:3 * s] = a[s:3 * s, s:3 * s]
    # 괄호 안 조건을 만족하는 경우의 인덱스를 모두 특정 변수로 나타냄
    c_0 = (c == 0)
    c[c_0] = b[c_0]
    # 가로, 세로, 대각선방향 총합
    calculate_sum(c, n)
    return c


def make_mabangjin(n):
    if n % 2 == 1 and n > 2:
        return make_mabangjin_odd(n)
    elif n % 4 == 0:
        return make_mabangjin_even(n)
    else:
        print("마방진을 구할 수 없습니다.")
        return


arr = make_mabangjin(int(input("정수 n을 입력하세요 : ")))
# return 존재하는 경우에만 아래 코드 작동
if arr is not None:
    print(arr)
