# 출력한 단수를 입력 받음
number = int(input("몇 단을 출력할까요? "))


# 구구단 출력 함수 정의
def multiplying(n):
    # 제목부터 출력
    print('%d단' % n)

    # 1부터 9까지 곱해준 결과를 계산식과 함께 출력
    for i in range(1, 10):
        # i가 홀수여야 하며, 곱셈 결과가 50 이하인 case만 출력함
        if i % 2 == 1 and number * i <= 50:
            print('%d X %d = %d' % (number, i, number * i))


# 결과 출력
multiplying(number)
