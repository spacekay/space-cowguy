package hw0727;

public class StableMember extends Member {

	public StableMember(String g) {
		this("���Է�","���Է�",0, g);		
	}

	public StableMember(String n, String p, int a, String g) {
		super(n,p,a,g);
	}

	@Override
	public void greet() {
		if (this.presence) {
			System.out.println("�ȳ��ϼ���, ���� "+this.group+"�� ������ �����ٿ� �����ϴ� "+this.position+" "+this.name+"�Դϴ�.");
			System.out.println("���� ���̴� "+age+"�Դϴ�.");
		} else {
			System.out.println("���� "+this.name+" ���� �ڸ��� ���ϴ�.");
			// ����� ���ɼ��� ����
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
