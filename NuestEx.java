package hw0727;

public class NuestEx {

	public static void main(String[] args) {

		Nuest nuest = new Nuest();
		
		System.out.println("<��ü�λ�>");
		nuest.allGreet();
		
		nuest.cmg = new StableMember("��", "����", 27, "���̽�Ʈ");
		
		System.out.println("<�����λ�>");
		nuest.allGreet();

	}

}
