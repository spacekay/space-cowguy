package setex210805;

public class Member {
	private int no;
	private String name;
	
	public Member (int n, String str) { // 기본생성자만 존재한다면 setter 필요
		this.name = str;
		this.no = n;
	}	
	// getter와 setter는 다 써주고 시작하기 (+ toString)
	// field값 편집 필요하면 setter도 필수
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
		return this.no+"번 회원 "+this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		// no 같으면 객체 자체도 같다고 판정해야 함
		// 그래야 HashSet에서 no만 가지고 판단할 수 있음
		// (다른 field가 중복 판정 결과에 관여하지 않음)
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return (member.no == no) ;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// 객체별로 가지고 있는 메모리 상의 주소값 : instance (객체 생성될 때마다 바뀜)
		// no값 같으면 해시코드 같은 것으로 가정
		return no;
	}
}
