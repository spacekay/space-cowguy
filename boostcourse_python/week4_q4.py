# Boostcourse Ellie Team 8 우주케이


# 양식에 맞는 주민번호를 입력받는 process를 보다 편리하게 호출하기 위해 별도 함수 정의
def input_id():
    # 주민등록번호를 입력받되, - 포함 14자리가 아닌 경우 재입력받음
    while True:
        input_data = input('주민등록번호를 입력하세요. (예시 : 123456-1234567) ')
        if len(input_data) != 14:
            print('잘못된 주민등록번호입니다.')
            continue
        elif input_data[6] != '-':
            print('잘못된 주민등록번호입니다.')
            continue
        else:
            break
    # 입력 받은 값은 return해야 이후 이 함수를 호출한 영역에서 사용할 수 있음
    return input_data


# 양식에 맞게 입력한 주민등록번호가 논리적으로 올바른지 검토하는 사실상 핵심 함수
def check_id():
    ssn = input_id()
    flag = False

    if 0 <= int(ssn[0:2]) < 22:
        select_ox = input('2000년 이후 출생자입니까? 맞으면 o 아니면 x : ')
        if select_ox == 'o' or select_ox == 'O':
            if ssn[7] == '3' or ssn[7] == '4':
                print_birth('20'+ssn[0:2], ssn[2:4], ssn[7])
                flag = True
            else:
                print('잘못된 번호입니다. 올바른 번호를 입력해주세요.')
                
        # 1900년대 출생자와 2000년대 출생자 구분하여 표기 필요 (위쪽도 수정 완료)
        elif select_ox == 'x' or select_ox == 'X':
            if ssn[7] == '1' or ssn[7] == '2':
                print_birth('19'+ssn[0:2], ssn[2:4], ssn[7])
                flag = True
            else:
                print('잘못된 번호입니다. 올바른 번호를 입력해주세요.')
    else:
        if ssn[7] == '1' or ssn[7] == '2':
            print_birth(ssn[0:2], ssn[2:4], ssn[7])
            flag = True
        else:
            print('잘못된 번호입니다. 올바른 번호를 입력해주세요.')
    return flag


# 데이터를 연도, 월, 성별 순으로 따로 input하여 처리 후 output에 반영
def print_birth(text1, text2, text3):
    gender = ""
    if text3 == '1' or text3 == '3':
        gender = '남자'
    else:
        gender = '여자'
    month = str(int(text2))
    print(text1 + '년 ' + month + '월생 ' + gender)


# 제작한 함수 check_id() 실행
# check_id()에서 return한 flag(bool type)가 true(정상 실행 완료)라면 프로그램 종료
# 아닌 경우 올바른 형식 자료를 받을 때까지 계속 프로그램 진행 반복
while True:
    result = check_id()
    if result:
        break
