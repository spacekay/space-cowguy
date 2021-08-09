package hw0727;

public class StableMember extends Member {

	public StableMember(String g) {
		this("미입력","미입력",0, g);		
	}

	public StableMember(String n, String p, int a, String g) {
		super(n,p,a,g);
	}

	@Override
	public void greet() {
		if (this.presence) {
			System.out.println("안녕하세요, 저는 "+this.group+"의 언제나 스케줄에 참석하는 "+this.position+" "+this.name+"입니다.");
			System.out.println("올해 나이는 "+age+"입니다.");
		} else {
			System.out.println("오늘 "+this.name+" 군은 자리를 비웁니다.");
			// 실행될 가능성이 없음
		}
		System.out.println();
	}
	
	@Override
	public boolean attend(int x) {
		switch(x) {
		default :
			return true;
		}
	}
}
