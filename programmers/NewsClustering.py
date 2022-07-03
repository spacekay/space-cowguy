# collections 라이브러리 사용하지 않음

def solution(str1, str2):
    
    str1 = str1.lower()
    str2 = str2.lower()
    
    alpha = ""
    
    list1 = []
    list2 = []
    
    # 문제 조건을 정확히 읽어서 전처리를 정확하게 했다면 빨리 해결했을 것 (중요)
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha():
            list1.append(str1[i:i+2])
            
    for i in range(len(str2)-1):
        if str2[i:i+2].isalpha():
            list2.append(str2[i:i+2])  
    
    # 직접 구현한 교집합 - 합집합 원소 수 구하는 로직 확인
    
    ja = []

    list3 = []

    for element in list1:
        list3.append(element)
    list4 = []

    for element in list2:
        list4.append(element)

    for element in list3:
        for element2 in list4:
            if element == element2:
                ja.append(element)
                list4.remove(element2)
                break

    jb = len(list1)+len(list2)-len(ja)
    
    # 예외처리도 유의할 것
    if jb == 0 and len(ja) == 0:
        answer = 65536
    else:
        answer = int(len(ja)/jb*65536)
    
    return answer
