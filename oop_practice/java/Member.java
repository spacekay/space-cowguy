package oop_practice;

public class Member {
	protected String name;
	protected String position;
	protected int age;
	protected final String group; 
	protected boolean presence;

	public Member(String g) {
		this("미입력","미입력",0, g);		
	}

	public Member(String n, String p, int a, String g) {
		this.name = n;
		this.position = p;
		this.age = a;
		this.group = g;
	}

	public void greet() {
		if (this.presence) {
			System.out.println("안녕하세요, 저는 "+this.group+"의 "+this.position+" "+this.name+"입니다.");
			System.out.println("올해 나이는 "+age+"입니다.");
		} else {
			System.out.println("오늘 "+this.name+" 군은 자리를 비웁니다.");
		}
		System.out.println();

	}

	public boolean attend(int x) {
		switch(x) {
		case 1 :
			return false;
		default :
			return true;
		}
	}
}
