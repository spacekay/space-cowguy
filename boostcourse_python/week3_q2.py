# random 함수 사용할 수 있도록 import
import random

# 경기 결과 기록할 변수 생성
win = 0
draw = 0
lose = 0

# 경기 진행할 회수 입력 받음
games = int(input("몇 번 게임을 진행할까요?"))

# 입력받은 회수만큼 for문 실행 (0부터 시작하는 것이 중요)
for i in range(0, games):
    # input은 기본적으로 string으로 이루어짐
    # while문을 통해 유효한 값이 들어오지 않은 경우 계속 입력 새로 받음
    while True:
        select = input("가위 바위 보! > ")
        if select != "0" and select != "1" and select != "2" and select != "가위" and select != "바위" and select != "보":
            games += 1
            continue
        else:
            break

    # input 값을 int 변수로 초기화
    code = 0

    # 입력값이 한글이건 숫자건 처리 가능하도록 if문 작성
    if select == "가위" or select == "0":
        code = 0
    elif select == "바위" or select == "1":
        code = 1
    elif select == "보" or select == "2":
        code = 2

    # 컴퓨터의 가위바위보 결과 코드화
    computer = random.randint(0, 2)

    # 함수 정의: mine이 컴퓨터이고 yours가 사용자 (컴퓨터 입장)
    # counter 역할의 변수는 global로 선언해야 for문이 끝난 뒤에도 값을 유지할 수 있음
    def play(mine, yours):
        global win, lose, draw
        if mine == 0:
            if yours == 1:
                print("이겼습니다.")
                win += 1
            elif yours == 2:
                print("졌습니다.")
                lose += 1
            else:
                print("비겼습니다.")
                draw += 1
        elif mine == 1:
            if yours == 2:
                print("이겼습니다.")
                win += 1
            elif yours == 0:
                print("졌습니다.")
                lose += 1
            else:
                print("비겼습니다.")
                draw += 1
        else:
            if yours == 0:
                print("이겼습니다.")
                win += 1
            elif yours == 1:
                print("졌습니다.")
                lose += 1
            else:
                print("비겼습니다.")
                draw += 1

    # 가위바위보 함수 실행
    play(code, computer)

# counter 변수들에 저장된 값들을 출력
print('이긴 횟수 : %d' % win)
print('진 횟수 : %d' % lose)
print('비긴 횟수 : %d' % draw)
