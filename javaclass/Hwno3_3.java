package hw;

public class Hwno3_3 {

	public static void main(String[] args) {
		int score = 85;
		String result = (!(score>90)) ? "가" : "나";
		// score>90은 거짓 -> 거짓의 !는 참 -> 가
		System.out.println(result);
	}

}
