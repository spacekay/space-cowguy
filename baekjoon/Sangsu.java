package string0;

import java.util.Scanner;

public class Sangsu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a;
		String b = "";
		int max = 0;
		int t = 0;
		int N = 0;

		while (t < 2) {
			a = sc.next();

			for (int i = 0 ; i < 3 ; i++) {
				b += a.charAt(2-i);
			}

			N = Integer.parseInt(b);

			if (max < N) {
				max = N;
			}
			t++;
			b= "";
		}

		System.out.println(max);

		sc.close();
	}
}
