# 두 개의 수 입력 받음
n = int(input("첫 번째 수 입력 : "))
m = int(input("두 번째 수 입력 : "))


def find_num(n1, m1):
    # n 이상 m 이하인 정수들을 모두 포함하는 int list 작성
    numbers = [i for i in range(n1, m1 + 1)]
    # numbers list 원소들 중 짝수만 걸러낸 list 만들기
    # n이 짝수냐 홀수냐에 따라 시작해야 하는 index가 달라짐
    if n1 % 2 == 1:
        new_list = numbers[1::2]
    elif n1 % 2 == 0:
        new_list = numbers[0::2]

    # new_list의 첫 번째 원소 및 마지막 원소를 추출
    a = new_list[0]
    b = new_list[len(new_list) - 1]
    median = 0

    # new_list 원소의 개수가 홀수일 때 median은 짝수가 됨
    # 다른 케이스에서는 median을 구할 필요 없음
    if len(new_list) % 2 == 1:
        median = (a + b) / 2

    # new_list 원소 자체가 짝수로만 이루어져 있으므로 그대로 출력 가능
    # median이 있는 경우만 median을 출력함
    for i in new_list:
        print('%d 짝수' % i)
        if i == median:
            print('%d 중앙값' % i)


find_num(n, m)
