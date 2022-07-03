# 다중집합 사용 가능한 라이브러리
from collections import Counter

def solution(str1, str2):
    
    str1 = str1.lower()
    str2 = str2.lower()
    
    alpha = ""
    
    list1 = []
    list2 = []
    
    # 문제 조건을 정확히 읽어서 전처리를 정확하게 했다면 빨리 해결했을 것
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha():
            list1.append(str1[i:i+2])
            
    for i in range(len(str2)-1):
        if str2[i:i+2].isalpha():
            list2.append(str2[i:i+2])  
    
    Counter1 = Counter(list1)
    Counter2 = Counter(list2)
    
    ja = list((Counter1 & Counter2).elements())
    jb = list((Counter1 | Counter2).elements())
    
    if len(jb) == 0 and len(ja) == 0:
        answer = 65536
    else:
        answer = int(len(ja)/len(jb)*65536)
    
    return answer
