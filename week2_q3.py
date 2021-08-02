# 이름과 점수를 입력해서 변수로 저장
name = input("이름을 입력하세요 > ")
score = int(input("점수를 입력하세요 > "))


# 점수대별로 grade를 다르게 부여하는 함수
def grader(str1, n):
    if n >= 95:
        grade = "A+"
    elif n >= 90:
        grade = "A"
    elif n >= 85:
        grade = "B+"
    elif n >= 80:
        grade = "B"
    elif n >= 75:
        grade = "C+"
    elif n >= 70:
        grade = "C"
    elif n >= 65:
        grade = "D+"
    elif n >= 60:
        grade = "D"
    else:
        grade = "F"
    print('학생 이름 : %s' % str1)
    print('점수 : %d' % score)
    print('학점 : %s' % grade)


# 입력받은 이름과 점수를 출력
grader(name, score)
