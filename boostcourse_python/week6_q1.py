# Boostcourse Ellie Team 8 우주케이


korea_king = "태조,혜종,정종,광종,경종,성종,목종,현종,덕종,정종,문종,순종,선종,헌종,숙종,예종,인종,의종,명종,신종,희종,강종,고종,원조,충렬왕,충선왕,충숙왕,충혜왕,충목왕,충정왕,공민왕,우왕," \
             "창왕,공양왕"
chosun_king = "태조,정종,태종,세종,문종,단종,세조,예종,성종,연산군,중종,인종,명종,선조,광해군,인조,효종,현종,숙종,경종,영조,정조,순조,헌종,철종,고종,순종"


def same_name(korea, chosun):
    # 왕 이름간에 책갈피 역할을 할 수 있는 키-값을 이어주는 데이터타입 dict 생성
    king_save = dict()
    # comma로 구분한 모든 왕들의 이름을 각각의 원소로 쪼개어 list로 만들어 줌
    korea = korea.split(",")
    chosun = chosun.split(",")
    # 모든 고려 왕들의 이름을 키로 하여 각각 동일한 값을 부여함 (초기화)
    for king in korea:
        king_save[king] = 1
    # 모든 조선 왕들의 이름을 고려 왕들의 이름과 비교하고, 같은 경우가 있는 경우 고려 왕 이름 키에 저장된 값을 바꿈
    for king in chosun:
        if king_save.get(king, 0) >= 1:
            king_save[king] = king_save[king]+1
        else:
            continue
    # 키 자체는 뽑아서 쓰기 어려우므로 중복이 존재하는 키들만을 담을 리스트를 추가 생성
    king_repeat = []
    for (k, v) in king_save.items():
        if v >= 2:
            king_repeat.append(k)
    cnt = 0
    # 리스트로 뽑아낸 모든 키들을 출력하고 키들의 총 개수를 함께 세어서 출력함
    for king in king_repeat:
        print("고려와 조선에는 둘 다 "+king+" 왕이 있었습니다.")
        cnt = cnt + 1
    print("고려와 조선에 모두 존재하는 왕의 시호는 "+str(cnt)+"개 입니다.")


same_name(korea_king, chosun_king)

