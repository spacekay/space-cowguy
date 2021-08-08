# Boostcourse Ellie Team 8 우주케이

num = input("0 이상의 숫자를 입력하세요.")


# 숫자를 문자열(str)로 읽어드려 자릿수에 따라 세 자리 단위로 나눈 뒤, 사이에 comma를 삽입한다.
# 맨 앞 부분은 자릿수에 따라 숫자 1개, 2개 다음 바로 comma가 올 수도 있으므로, 별도 조건을 추가한다.

def comma_maker(n):
    new_num = ""
    # 받아들인 문자열의 길이를 측정하여 이후 알고리즘의 주요 도구로 삼는다.
    length = len(n)
    if length % 3 == 0:
        for i in range(0, length):
            if i == 2:
                new_num = n[0:3]
            elif i % 3 == 0 and i != 0:
                new_num = new_num + "," + n[i:i+3]
                # 파이썬에서 [m:n]은 m 이상 n '미만'의 인덱스를 의미
    elif length % 3 == 1:
        for i in range(0, length):
            if i == 0:
                new_num = n[0]
            elif (i+2) % 3 == 0:
                new_num = new_num + "," + n[i:i+3]
    else:
        for i in range(0, length):
            if i == 1:
                new_num = n[0:2]
            elif (i+1) % 3 == 0:
                new_num = new_num + "," + n[i:i+3]
    # 결과는 str로 return한다.
    return new_num


comma_made = comma_maker(num)
print(comma_made)
