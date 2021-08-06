import java.util.Scanner;

public class Melody {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] melody = new int[8];
		
		for (int i = 0 ; i < 8 ; i++ ) {
			melody[i] = sc.nextInt();
		}
		
		boolean ascending = false;
		boolean descending = false;
		
    // 조건을 정확하게 하는 것도 좋지만 너무 까다로우면 속도 느려진다.
		for (int i = 1 ;  i < 8 ; i++) {
			if(melody[i]-melody[i-1] == 1 && !descending) {
				ascending = true;
			} else if (melody[i]-melody[i-1] == -1 && !ascending) {
				descending = true;
			} else {
				ascending = false;
				descending = false;
				break;
			}
		}
		
		if (ascending) {
			System.out.println("ascending");
		} else if (descending) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		sc.close();
	}
}
