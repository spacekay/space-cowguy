# Boostcourse Ellie Team 8 우주케이
import random

print("배스킨~ 라빈스~ 3~ 1!")
max_num = 0


# 데이터 타입 관련한 부분 오류를 신경써야 함
def count_human_num():
    my_num = input("\n당신의 순서입니다. 1개 ~ 3개의 연속한 숫자를 불러 보세요.\n> ")
    # 현재 턴 기준 최고 숫자를 불러옴
    global max_num
    # String 형식의 list로 생성함
    my_list = my_num.split()
    # 잘못된 입력을 방지함
    if int(my_list[0]) != int(max_num) + 1:
        return 0
    if len(my_list) == 0 or len(my_list) > 3:
        return 0
    # 성분별 비교를 위해 초기값을 미리 별도 변수에 저장함
    num_before = int(my_list[0])
    # 리스트의 크기에 따라 for문 작동 회수가 가변적이도록 설정
    for i in range(0, len(my_list)):
        # 원하는 범위를 초과하는 숫자를 발견하는 즉시 재시작
        if int(my_list[i]) > 3 + max_num:
            return 0
        # 두번째, 세번째 성분들이 존재한다면 옳은 값인지 검증
        if i >= 1:
            if int(my_list[i]) != num_before + 1:
                return 0
            num_before = int(my_list[i])
        if my_list[i] == '31':
            print('앗! 당신의 패배입니다. 컴퓨터가 승리했군요.')
            return -1
        else:
            print('나 : ' + my_list[i])
    # 게임이 이번 턴에 끝나지 않은 경우 최고값을 저장한 후 이번 턴 플레이 종료
    max_num = my_list[len(my_list) - 1]
    return 1


def count_computer_num():
    # 현재 턴의 최고값 불러옴 (나의 턴 끝난 후)
    global max_num
    print('\n컴퓨터가 숫자를 부릅니다.')
    # 랜덤 함수를 import하여 임의로 리스트 크기 생성
    random_num = int(random.random() * 3 + 1)
    com_list = list()
    # 아래 for문의 range가 list의 크기를 결정하게 됨
    for i in range(0, random_num):
        # int 형식의 list로 사용함
        com_list.append(i + 1 + int(max_num))
        print('컴퓨터 : ' + str(com_list[i]))
        if com_list[i] == 31:
            print('와! 컴퓨터가 패배했습니다. 당신이 승리했군요.')
            return -1
    # 게임이 이번 턴에 끝나지 않은 경우 최고값을 저장한 후 이번 턴 플레이 종료
    max_num = com_list[random_num - 1]
    return 1


# 실제 작동
while True:
    try:
        # 각 함수에서의 처리 결과를 나타내는 return 별로 다른 결과를 발생시킴
        x = count_human_num()
        if x == 0:
            print('규칙에 맞게 정확히 입력하세요.')
            continue
        elif x == -1:
            break
        x = count_computer_num()
        if x == -1:
            break
    # 실수로 한글 등 원하지 않는 문자를 입력한 경우
    except ValueError:
        print('규칙에 맞게 정확히 입력하세요.')
