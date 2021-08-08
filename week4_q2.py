# Boostcourse Ellie Team 8 우주케이

text_all = input("검색을 실행할 전체 텍스트를 입력하세요. ")
text_search = input("검색을 실행할 키워드를 입력하세요. ")


def count_word(str1, str2):
    # 한글을 처리하기 위해서는 UTF8로 처리하는 것이 필수적
    # 쓰기 전용으로 한 번 읽기
    text_count = open('for_search.txt', 'w', encoding="UTF8")
    
    # 텍스트 파일로 입력하기 전 str1의 문자들 중 영문인 경우 모두 소문자로 변경
    # 자료의 초기값은 미리 세팅하는 것이 유리
    text_retype = ""
    for s in str1:
        if s.encode().isalpha():
            s = s.lower()
        text_retype = text_retype + s

    # 알파벳을 모두 소문자로 변경한 문자열을 텍스트 파일에 저장함
    text_count.write(text_retype)
    text_count.close()

    # 읽기 전용으로 다시 읽어주기 (close()로 한 번은 닫아야 다시 읽기 가능)
    # 쓰기 전용인 상태로 읽으면 한글 처리할 때 io.UnsupportedOperation: not readable 발생
    # encoding tag 없으면 UnicodeDecodeError 발생
    # 쓰기 작업이 필요하지 않다면 안전하게 읽기 전용으로 읽어주기
    text_reopen = open('for_search.txt', 'r', encoding="UTF8")
    cnt = 0
    word_keyword = ""

    # 입력한 키워드(str2)의 양쪽에 공백이 있는 경우 대비
    word_type = str2.strip()

    # 입력한 키워드(str2)의 대소문자 관계 없이 검색 가능하게 처리
    text_retype = ""
    for s in word_type:
        if s.encode().isalpha():
            s = s.lower()
        text_retype = text_retype + s
    word_type = text_retype

    # text 파일을 한 번 닫았다 다시 읽어들일 때 자동으로 모든 단어가 줄바꿈되어 들어옴
    # 여기서의 라인은 띄어쓰기된 문자열 하나하나를 의미함
    for line in text_reopen:
        if word_type in line:

            # 종종 띄어쓰기가 제대로 되어있지 않은 텍스트가 들어올 수 있으므로 아래 구문이 필요
            # 일단 해당 단어가 라인 안에 하나라도 있으면 아래 for 문부터 작동 시작
            # word_keyword에 글자를 하나씩 넣어봄 -> 결과적으로 입력된 모든 텍스트를 검색 가능
            for s in line:
                word_keyword = word_keyword + s

                # 생성된 word_keyword가 word_type와 동일해지는 순간에만 작동
                # 왼쪽 끝에 공백이 있는 경우는 무시하고 그 사이 키워드만 확인 (띄어쓰기 포함)
                if word_keyword.lstrip() == word_type:
                    cnt = cnt + 1
                    word_keyword = ""

                # word_type에 들어있는 문자열 중 일부가 생성된 word_keyword에 포함되어 있어야 실행 가능
                # 위의 경우와 마찬가지로 해당 알고리즘이 왼쪽 끝 공백의 영향을 받지 않도록 처리
                if word_keyword.lstrip() in word_type:
                    word_keyword = word_keyword[0:]
                    word_temp = word_keyword.lstrip()

                    # 또한 word_keyword.lstrip()은 word_type과 첫 글자가 동일해야만 함
                    if len(word_temp) != 0:
                        if word_temp[0] != word_type[0]:
                            word_keyword = ""
                else:
                    # 연속되게 원하는 문자열이 들어오지 않으면 바로 리셋
                    # 해당 단어가 있을 때만 cnt가 증가
                    word_keyword = ""

    print('입력한 텍스트(' + word_type + ')의 총 등장 횟수 : ' + str(cnt))


count_word(text_all, text_search)
