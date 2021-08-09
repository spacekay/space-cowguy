package setex210805;

public class Member {
	private int no;
	private String name;
	
	public Member (int n, String str) { // �⺻�����ڸ� �����Ѵٸ� setter �ʿ�
		this.name = str;
		this.no = n;
	}	
	// getter�� setter�� �� ���ְ� �����ϱ� (+ toString)
	// field�� ���� �ʿ��ϸ� setter�� �ʼ�
	public int getNum() {
		return this.no;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String str) {
		this.name = str;
	}
	
	public void setNum(int n) {
		this.no = n;
	}
		
	@Override
	public String toString() {
		return this.no+"�� ȸ�� "+this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		// no ������ ��ü ��ü�� ���ٰ� �����ؾ� ��
		// �׷��� HashSet���� no�� ������ �Ǵ��� �� ����
		// (�ٸ� field�� �ߺ� ���� ����� �������� ����)
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return (member.no == no) ;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// ��ü���� ������ �ִ� �޸� ���� �ּҰ� : instance (��ü ������ ������ �ٲ�)
		// no�� ������ �ؽ��ڵ� ���� ������ ����
		return no;
	}
}
