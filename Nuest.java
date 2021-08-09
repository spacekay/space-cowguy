package hw0727;

public class Nuest {
	// field
	Member kjh = new Member("JR", "리더", 27, "뉴이스트");
	Member kar = new Member("아론", "맏형", 29, "뉴이스트");
	Member kdh = new Member("백호", "메인보컬", 27, "뉴이스트");
	Member hmh = new Member("민현", "리드보컬", 27, "뉴이스트");
	Member cmg = new Member("렌", "막내", 27, "뉴이스트");
	// 멤버 각각이 다른 곳에서 또 소환될 수도 있으므로 array로 쓰기는 어려웠던 것 같다.

	// constructor

	// method
	public void eachGreet(Member anyone) {
			anyone.presence = anyone.attend((int)(Math.random()*10)+1);
			// 일반 멤버는 10% 확률로 스케줄에 불참할 수 있음
			// 안정적인 멤버는 무조건 스케줄 참석함
			anyone.greet();
	}
	
	public void allGreet() {
		this.eachGreet(kjh);
		this.eachGreet(kar);
		this.eachGreet(kdh);
		this.eachGreet(hmh);
		this.eachGreet(cmg);
	}
}
