# 일반적 사용자들이 이용하기 편하도록 만원 단위로 입력할 것을 요청
monthly = int(input("만원 단위로 월급을 입력해 주세요. > "))

# 1년 12개월 동안 월급이 동일하다고 가정하여 세전 연봉 산출
yearly_pre = monthly*12
# 세후 연봉 변수 초기화
yearly_post = 0

# 소득 구간별로 세율이 변동하므로, if 문을 통해 작은 금액부터 걸러냄
# 이상이하 - 초과미만 정확히 구분하여야 함
if yearly_pre <= 1200:
    yearly_post = yearly_pre*0.94
elif yearly_pre <= 4600:
    yearly_post = yearly_pre*0.85
elif yearly_pre <= 8800:
    yearly_post = yearly_pre*0.76
elif yearly_pre <= 15000:
    yearly_post = yearly_pre*0.65
elif yearly_pre <= 30000:
    yearly_post = yearly_pre*0.62
elif yearly_pre <= 50000:
    yearly_post = yearly_pre*0.6
else:
    yearly_post = yearly_pre*0.58

# 세후 연봉 확인이 끝나고, 세전 세후 연봉을 금액 단위에 따라 다르게 출력
# 1억이 넘는 경우 억 단위 표시를 별도로 하여 줌
if yearly_pre < 10000:
    print('세전 연봉 : %d만원' % yearly_pre)
else:
    print('세전 연봉 : %d억 %d만원' % (yearly_pre/10000, yearly_pre%10000))

if yearly_post < 10000:
    print('세후 연봉 : %d만원' % yearly_post)
else:
    print('세후 연봉 : %d억 %d만원' % (yearly_post / 10000, yearly_post % 10000))
