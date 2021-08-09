package setex210806;

public class Student implements Comparable<Student> {
	private String id;
	private String name;

	public Student(String str1, String str2) {
		this.id = str1;
		this.name = str2;
	}

	public Student(String str) {
		this.id = str;
		this.name = "Unknown";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "아이디 : "+this.id+" / 이름 : "+this.name;
	}

	@Override
	public boolean equals(Object obj) { // 아이디로만 구분
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return (student.id.equals(this.id)) ;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public int compareTo(Student s) { // 양수 음수만 구별하면 됨
		return this.id.compareTo(s.id); // 번호로만 정렬하기로 함
		// 파라미터 객체의 값이 더 크면 양수 : 내림차순, 반대 : 오름차순
	}	
}
