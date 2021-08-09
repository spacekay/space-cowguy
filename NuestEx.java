package hw0727;

public class NuestEx {

	public static void main(String[] args) {

		Nuest nuest = new Nuest();
		
		System.out.println("<전체인사>");
		nuest.allGreet();
		
		nuest.cmg = new StableMember("렌", "막내", 27, "뉴이스트");
		
		System.out.println("<별도인사>");
		nuest.allGreet();

	}

}
