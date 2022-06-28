def solution(numbers):
    order = [-1 for _ in range(len(numbers))]
    sim = []
    
    # custom test case : [919, 91, 9, 0] -> 9919910
    # [919, 91, 9, 0] => [919 9, 91 91, 9 9 9 9, 0] : 해당 숫자가 첫째 자리부터 네자리까지 반복되도록 보정
    
    for i in range(len(numbers)):
        if numbers[i] == 1000:
            sim.append([i, 1000])
        elif numbers[i] > 99:
            sim.append([i, numbers[i]*10+(int(numbers[i]/100)%10)])
        elif numbers[i] > 9:
            sim.append([i, numbers[i]*100+numbers[i]])
        else:
            sim.append([i, numbers[i]*1111])
    
    order = sorted(sim, key = lambda x:-x[1])
    
    answer = ''
    
    # 예외 처리 (주어진 모든 숫자가 0인 경우 0을 1개만 출력해야 함)
    if order[0][1] == 0:
        answer = '0'
    else:
        for j in range(len(numbers)):
            answer = answer + str(numbers[order[j][0]])
    return answer
