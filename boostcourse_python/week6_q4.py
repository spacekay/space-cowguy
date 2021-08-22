# Boostcourse Ellie Team 8 우주케이

# 6명의 회원이고 "아이디,나이,전화번호,성별,지역,구매횟수" 순서로 입력되어 있음
# 이 자료 역시 두 번에 걸쳐 분류가 필요
info = "abc,21세,010-1234-5678,남자,서울,5,cdb,25세,x,남자,서울,4,bbc,30세,010-2222-3333,여자,서울,3," \
       "ccb,29세,x,여자,경기,9,dab,26세,x,남자,인천,8,aab,23세,010-3333-1111,여자,경기,10"


def vip_member(record):
    # 모든 자료의 세부 원소를 하나하나 comma를 이용해 쪼갬
    record = record.split(",")
    record_dict = dict()
    for i in range(0, int(len(record)/6)):
        # 쪼개 놓은 자료들을 하나씩 각각의 attribute 필드에 값을 넣어줌
        # 한 사람당 6개의 필드를 가지므로 record 리스트의 원소 6개씩 순서대로 넣어줌
        # 필드 자체가 없는 경우에는 새롭게 만들어주고 거기에 값을 넣는 동작 필요
        if i == 0:
            record_dict["아이디"] = [record[0]]
            record_dict["나이"] = [record[1]]
            record_dict["전화번호"] = [record[2]]
            record_dict["성별"] = [record[3]]
            record_dict["지역"] = [record[4]]
            record_dict["구매횟수"] = [record[5]]
        else:
            record_dict["아이디"].append(record[i*6])
            record_dict["나이"].append(record[i*6+1])
            record_dict["전화번호"].append(record[i*6+2])
            record_dict["성별"].append(record[i*6+3])
            record_dict["지역"].append(record[i*6+4])
            record_dict["구매횟수"].append(record[i*6+5])
    # 전화번호를 입력하지 않은 사람과, 구매횟수가 8회 이상인 사람을 입력된 자료를 기준으로 검색
    no_phone_num = []
    vip_candidate = []
    for i in range(0, len(record_dict["아이디"])):
        if record_dict["전화번호"][i] == "x":
            no_phone_num.append(i)
            record_dict["전화번호"][i] = "010-0000-0000"
        if int(record_dict["구매횟수"][i]) > 7:
            vip_candidate.append(i)
    # 구매횟수 8 이상인 사람들 중에 전화번호를 입력하지 않은 사람들을 제외함
    vip_final = []
    for i in vip_candidate:
        if i not in no_phone_num:
            vip_final.append(i)
    # 전체 회원 정보가 들어있는 dict 출력
    print(record_dict.items())
    # 할인 쿠폰 발급 대상인 사람들만 최종 출력
    print('<할인 쿠폰 발급 대상>')
    t = 0
    for i in vip_final:
        t = t + 1
        print(f'아이디 : {record_dict["아이디"][i]}\n나이 : {record_dict["나이"][i]}\n'
              f'전화번호 : {record_dict["전화번호"][i]}\n성별 : {record_dict["성별"][i]}\n'
              f'지역 : {record_dict["지역"][i]}\n구매횟수 : {record_dict["구매횟수"][i]}')


vip_member(info)
