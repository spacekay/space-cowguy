def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        command = commands[i]
        
        # x번째 원소의 리스트 상 번호는 x-1임을 기억한다.
        
        tmp = array[(command[0]-1):command[1]]
        tmp.sort()
        answer.append(tmp[command[2]-1])
    return answer
