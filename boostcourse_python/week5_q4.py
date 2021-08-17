# Boostcourse Ellie Team 8 우주케이

print("오늘의 첫 만남을 기록합시다! 오늘부터 1일!")


# index는 0부터 시작함에 유의하며 연산
def find_100days():
    # 매달 일수
    dates = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    # 요일 종류
    days = ['월', '화', '수', '목', '금', '토', '일']

    # 잘못된 입력 미리 걸러내기 (월, 일)
    mon = int(input("지금은 몇 월인가요?\n> "))
    if mon > 12 or mon < 0:
        return 0
    date = int(input("오늘은 몇 일인가요?\n> "))
    if date > dates[mon - 1] or date < 0:
        return 0
    day = input("오늘은 무슨 요일인가요? (한 글자로 입력)\n> ")

    # 최종 출력할 변수는 for 문 밖에서 선언
    month_new = mon
    day_new = day
    date_new = 99 - (dates[mon - 1] - date)

    # month와 date의 최대값을 넘는 경우 index error가 발생하므로 구분하여 if 문 사용
    for i in range(mon, mon + 4):
        # index error 방지할 수 있도록 처리
        if i < 11:
            date_new = date_new - dates[i]
            # 각 달의 date 값에 따라 month 출력값도 달라짐
            if date_new < dates[i + 1]:
                month_new = i + 2
                break
        # 특수한 케이스를 별도 분리
        elif i == 11:
            date_new = date_new - dates[i]
            if date_new < dates[i - 11]:
                month_new = i - 10
                break
        else:
            date_new = date_new - dates[i - 12]
            if date_new < dates[i - 11]:
                month_new = i - 10
                break

    # 요일(day)은 출력값 산출 로직에 잘못된 입력을 걸러내는 내용도 포함
    for i in range(0, 7):
        # index error 방지할 수 있도록 처리
        if day == days[i] and i < 6:
            day_new = days[i + 1]
            break
        elif day == days[i]:
            day_new = days[i - 6]
            break
        else:
            if i == 6:
                return 0
    print()
    print('당신의 100일 기념일은 ''%d월 %d일 %s요일'' 입니다.' % (month_new, date_new, day_new))
    return 1


# 실행문
while True:
    x = find_100days()
    # 함수의 return에 따라 다른 동작 진행 (재진행 또는 중지)
    if x == 0:
        print('잘못된 입력입니다.')
        continue
    elif x == 1:
        break
