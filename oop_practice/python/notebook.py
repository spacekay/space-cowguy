class Note(object):
    def __init__(self, contents=None):
        self.contents = contents

    def write_contents(self, contents):
        self.contents = contents

    def remove_all(self):
        self.contents = ""

    def __str__(self):
        return self.contents

    def get_number_of_characters(self):
        return len(self.contents)

    def get_number_of_lines(self):
        return self.contents.count("\n")+1


class NoteBook(object):
    # __int__라는 함수가 따로 있으므로 오타 주의
    def __init__(self, title):
        self.title = title
        self.pages = 0
        self.notes = {}

    def add_note(self, note, page_number=0):
        if len(self.notes.keys()) < 300:
            if page_number == 0:
                # 기록된 페이지 기준 (앞에 한두장 없어져도 이건 앞으로 이동하지 않음)
                if self.pages < 301:
                    self.notes[self.pages] = note
                    self.pages += 1
                else:   # 실제 저장된 값은 300보다 작지만 페이지수 자체는 더 큰 경우
                    for i in range(300):
                        # 그냥 리스트 상에서만 i가 중간에 섞이는 거고 저장 순서는 가장 마지막에 와야 함
                        if i not in list(self.notes.keys()):
                            self.notes[self.pages] = note
            else:  # 입력할 특정 페이지를 지정한 경우
                if page_number not in self.notes.keys():
                    self.notes[page_number] = note
                else:
                    print(f'** {page_number}페이지에는 이미 노트가 존재합니다.')
        else:
            print("** 최대 페이지 수를 초과하였습니다.")

    def remove_note(self, page_number):
        # .keys() 함수의 return은 list이다!
        del self.notes[page_number]

    def get_number_of_all_lines(self):
        result = 0
        for k in self.notes.keys():
            result += self.notes[k].get_number_of_lines()
        return result

    def get_number_of_all_pages(self):
        return len(self.notes.keys())

    def get_number_of_all_characters(self):
        result = 0
        for k in self.notes.keys():
            result += self.notes[k].get_number_of_characters()
        return result

    def __str__(self):
        return self.title
