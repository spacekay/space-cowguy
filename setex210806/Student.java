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
		return "���̵� : "+this.id+" / �̸� : "+this.name;
	}

	@Override
	public boolean equals(Object obj) { // ���̵�θ� ����
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
	public int compareTo(Student s) { // ��� ������ �����ϸ� ��
		return this.id.compareTo(s.id); // ��ȣ�θ� �����ϱ�� ��
		// �Ķ���� ��ü�� ���� �� ũ�� ��� : ��������, �ݴ� : ��������
	}	
}
