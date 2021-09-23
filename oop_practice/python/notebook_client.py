from notebook import Note
from notebook import NoteBook

song = """학교 종이 땡땡땡 어서 모이자\n선생님이 우리를 기다리신다"""
note_1 = Note(song)

song = """깊고 작은 옹달샘 누가 찾고 있나요"""
note_2 = Note(song)

song = """까치까치 설날은 어저께고요\n우리우리 설날은 오늘이래요"""
note_3 = Note(song)

song = """동구 밖 과수원길 아카시아 꽃이 활짝 폈네\n하얀 꽃 이파리 눈송이처럼 날리네"""
note_4 = Note(song)

print("** 4페이지 라인수 :", note_4.get_number_of_lines())
print("** 4페이지 글자수 :", note_4.get_number_of_characters())

song_notebook = NoteBook("대한민국 동요곡집")

song_notebook.add_note(note_1)
song_notebook.add_note(note_2)
song_notebook.add_note(note_3)
song_notebook.add_note(note_4)

for i in range(301):
    song_notebook.add_note(note_1, i)

for i in range(5):
    print(song_notebook.notes[i])

print("** 페이지수 :", song_notebook.get_number_of_all_pages())
print("** 라인수 :", song_notebook.get_number_of_all_lines())
print("** 글자수 :", song_notebook.get_number_of_all_characters())
print("** 노트 이름 :", song_notebook)
