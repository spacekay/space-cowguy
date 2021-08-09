package oop_practice;

public class Member {
	protected String name;
	protected String position;
	protected int age;
	protected final String group; 
	protected boolean presence;

	public Member(String g) {
		this("���Է�","���Է�",0, g);		
	}

	public Member(String n, String p, int a, String g) {
		this.name = n;
		this.position = p;
		this.age = a;
		this.group = g;
	}

	public void greet() {
		if (this.presence) {
			System.out.println("�ȳ��ϼ���, ���� "+this.group+"�� "+this.position+" "+this.name+"�Դϴ�.");
			System.out.println("���� ���̴� "+age+"�Դϴ�.");
		} else {
			System.out.println("���� "+this.name+" ���� �ڸ��� ���ϴ�.");
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
