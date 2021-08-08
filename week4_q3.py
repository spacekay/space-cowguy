# Boostcourse Ellie Team 8 우주케이

# 이 중 올바르게 입력한 자료는 이을영과 허정모의 것 뿐
saved_text = """김갑우,123456789
이을영,010-1234-5678
박병후,010-5678-111
최중,111-1111-1111
허정모,010-3333-3333"""


def guest_check(text):
    # 한글을 처리하는 자료는 항상 encoding에 신경써서 쓰고 읽음
    guestbook = open('guestbook.txt', 'w', encoding="UTF8")
    guestbook.write(text)
    guestbook.close()

    guestbook_find = open('guestbook.txt', 'r', encoding="UTF8")

    for line in guestbook_find:
        # 불필요한 공백으로 인한 오류는 항상 방지
        line_trimmed = line.strip()

        # 이름 글자 수와 관계 없이 이름과 번호의 경계를 찾기 위함
        # 또한 해당 line에서의 index 기준점으로 활용 가능
        i = line_trimmed.find(',')

        # 문제에서 주어진 조건들을 하나씩 적용
        # 한 번에 중첩 조건문으로 사용할 수도 있겠지만 너무 라인 하나의 내용이 길어지므로
        # elif를 활용하여 걸러냈음
        if line_trimmed[i + 1:i + 4] != '010':
            print_wrong(line_trimmed[0:i], line_trimmed[i + 1:])
        elif line_trimmed[i + 4] != '-' or line_trimmed[i + 9] != '-':
            print(line_trimmed[i + 8])
            print_wrong(line_trimmed[0:i], line_trimmed[i + 1:])
        elif len(line_trimmed[i + 1:]) != 13:
            print_wrong(line_trimmed[0:i], line_trimmed[i + 1:])


# guest_check 함수에서 잘못 입력한 정보로 처리한 경우 출력하는 함수
# 이름 부분과 번호 부분은 구분하여 input하는 것이 함수의 구조를 간단하게 하는데에 유리함
def print_wrong(text1, text2):
    print('잘못 쓴 사람 : ' + text1)
    print('잘못 쓴 번호 : ' + text2)
    print()


guest_check(saved_text)
