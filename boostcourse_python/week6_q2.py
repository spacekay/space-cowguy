# Boostcourse Ellie Team 8 우주케이

# 분석 대상인 자료는 문제에서 그대로 가져옴
member_names = ["갑돌이", "갑순이", "을돌이", "을순이", "병돌이", "병순이"]
member_records = [[4, 5, 3, 5, 6, 5, 3, 4, 1, 3, 4, 5], [2, 3, 4, 3, 1, 2, 0, 3, 2, 5, 7, 2],
                  [1, 3, 0, 3, 3, 4, 5, 6, 7, 2, 2, 1], [3, 2, 9, 2, 3, 5, 6, 6, 4, 6, 9, 9],
                  [8, 7, 7, 5, 6, 7, 5, 8, 8, 6, 10, 9], [7, 8, 4, 9, 5, 10, 3, 3, 2, 2, 1, 3]]


def sales_rank(names, records):
    sales_dict = dict()
    # 각 직원의 이름(str)을 키(k)로, 전체 실적(list)을 값(v)으로 저장함
    for i in range(0, len(names)):
        sales_dict[names[i]] = records[i]
    # 실질적인 판단은 전체 실적의 평균값으로 진행하므로,
    # 값을 비교적 복잡한 리스트에서 하나의 수로 변경
    for (k, v) in sales_dict.items():
        sum_records = 0
        for i in v:
            sum_records = sum_records + i
        avg_records = sum_records / len(v)
        sales_dict[k] = avg_records
    # 평균 실적 순으로 dict 내부 정렬 (임시로 키와 값을 위치를 바꾸어 계산)
    ranked_dict = [(v, k) for k, v in sales_dict.items()]
    ranked_dict = sorted(ranked_dict, reverse=True)
    # 보너스 대상자와 면담 대상자를 담을 리스트 각각 생성
    # 값을 저장해야 원래 dict의 키가 저장됨
    bonus_ppl = [ranked_dict[0][1], ranked_dict[1][1]]
    interview_ppl = [ranked_dict[len(names) - 2][1], ranked_dict[len(names) - 1][1]]
    # 보너스 대상자부터 출력 (이름, 평균 실적 같이 출력)
    for ppl in bonus_ppl:
        if sales_dict[ppl] < 5:
            continue
        else:
            print("보너스 대상자 : " + ppl + "(" + str(round(sales_dict[ppl], 2)) + ")")
    print()
    # 면담 대상자 출력
    for ppl in interview_ppl:
        if sales_dict[ppl] > 3:
            continue
        else:
            print("면담 대상자 : " + ppl + "(" + str(round(sales_dict[ppl], 2)) + ")")


sales_rank(member_names, member_records)
