def solution(str1, str2):
    
    str1 = str1.lower()
    str2 = str2.lower()
    
    alpha = ""
    
    list1 = []
    list2 = []
    
    for letter in str1:
        if alpha == "":
            alpha = letter
        elif letter.isalpha() or letter.isdigit():
            alpha = alpha + letter
            list1.append(alpha)
            alpha = letter
    
    alpha = ""
    
    # 전처리
    for letter in str2:
        if alpha == "":
            alpha = letter
        elif letter.isalpha() or letter.isdigit():
            alpha = alpha + letter
            list2.append(alpha)
            alpha = letter    
    
    print(list1)
    print(list2)
    
    ja = []
    jb = set()
    
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
    
    print(list4, '*')
    
    print(ja)
    
    jb = len(list1)+len(list2)-len(ja)
    
    print(len(ja), jb)
    
    if jb > 0 :
        answer = int(len(ja)/jb*65536)
    else:
        answer = 1
    
    return answer
