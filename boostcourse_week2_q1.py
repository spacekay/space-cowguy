# random 함수 사용할 수 있도록 import
import random

# input은 기본적으로 string으로 이루어짐
select = input("가위 바위 보! > ")
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


# 함수 정의 : mine이 컴퓨터이고 yours가 사용자 (컴퓨터 입장)
def play(mine, yours):
    if mine == 0:
        if yours == 1:
            print("이겼습니다.")
        elif yours == 2:
            print("졌습니다.")
        else:
            print("비겼습니다.")
    elif mine == 1:
        if yours == 2:
            print("이겼습니다.")
        elif yours == 0:
            print("졌습니다.")
        else:
            print("비겼습니다.")
    else:
        if yours == 0:
            print("이겼습니다.")
        elif yours == 1:
            print("졌습니다.")
        else:
            print("비겼습니다.")


# 가위바위보 함수 실행
play(code, computer)
