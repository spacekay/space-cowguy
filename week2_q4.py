# 사용자의 나이와 지불방식을 입력받음
years = int(input("나이를 입력하세요 > "))
types = input("계산 방식을 입력하세요 (카드 / 현금) > ")


# 버스 요금 계산 함수를 정의함
# 나이 순으로 1차로 거른 뒤 지불 방식별 차이가 있는 경우에 한해서만 중첩 if문 사용
def bus_fare(age, style):
    if age < 8 or age >= 75:
        fee = 0
    elif age >= 20:
        if style == "카드":
            fee = 1200
        else:
            fee = 1300
    elif age >= 14:
        if style == "카드":
            fee = 720
        else:
            fee = 1000
    else:
        fee = 450
    print('나이 : %d세' % age)
    print('지불유형 : %s' % style)
    print('버스요금 : %d원' % fee)


# 입력받은 값들을 함수에 대입하여 실행 완료
bus_fare(years, types)
