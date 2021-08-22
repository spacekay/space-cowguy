# Boostcourse Ellie Team 8 우주케이

stocks = "삼성전자/10/85000,카카오/15/130000,LG화학/3/820000,NAVER/5/420000"
# stocks를 일반 str에서 사람별로 다른 성분을 가지는 str 리스트로 미리 만들어 둠
stocks = stocks.split(",")
sells = [82000, 160000, 835000, 410000]


def stock_profit(stock_list, sell_list):
    stock_dict = dict()
    # stock_list의 정보는 내부에서 한 번 더 쪼개어 각각 세 가지 성분을 가지도록 해야 함
    stock_new = stock_list
    t = 0
    for stock in stock_list:
        stock_new[t] = stock.split("/")
        t = t + 1
    # 쪼개어 만든 stock_new 원소들의 세 가지 성분 중 첫 번째 성분은 회사 이름, 세 번째 성분은 현재가
    # 회사 이름을 키로, 현재가를 이용하여 수익률을 구한 결과를 최종 값으로 취하여 dict를 완성함
    for i in range(0, t):
        stock_dict[stock_new[i][0]] = (sell_list[i]-int(stock_new[i][2]))/int(stock_new[i][2])    
    # 수익률을 키로 만들어 내림차순으로 sort함
    ranked_stock = [(v, k) for k, v in stock_dict.items()]
    ranked_stock = sorted(ranked_stock, reverse=True)
    # 값으로 저장된 회사 이름과 키로 저장된 수익률을 반대 순서로 출력
    for (k, v) in ranked_stock:
        print(f"{v}의 수익률 : {k:.2}")


stock_profit(stocks, sells)
