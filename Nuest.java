package hw0727;

public class Nuest {
	// field
	Member kjh = new Member("JR", "����", 27, "���̽�Ʈ");
	Member kar = new Member("�Ʒ�", "����", 29, "���̽�Ʈ");
	Member kdh = new Member("��ȣ", "���κ���", 27, "���̽�Ʈ");
	Member hmh = new Member("����", "���庸��", 27, "���̽�Ʈ");
	Member cmg = new Member("��", "����", 27, "���̽�Ʈ");
	// ��� ������ �ٸ� ������ �� ��ȯ�� ���� �����Ƿ� array�� ����� ������� �� ����.

	// constructor

	// method
	public void eachGreet(Member anyone) {
			anyone.presence = anyone.attend((int)(Math.random()*10)+1);
			// �Ϲ� ����� 10% Ȯ���� �����ٿ� ������ �� ����
			// �������� ����� ������ ������ ������
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
