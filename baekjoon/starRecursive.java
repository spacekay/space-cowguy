package recursive;

import java.util.Scanner;

public class starRecursive {


	int a = 0;

	private static String[] star1(int n) {

		String plus = "";
		String[] star = new String[n];

		if (n==3) {
			star[0] = "***";
			star[1] = "***";
			star[2] = "***";
			return star;
		} else {
			for (int j = 0 ; j < n/3 ; j++) {

				star[j] = "";
				plus = "";

				if ((j+1)%3==2) {
					for(int i = 0 ; i < 3 ; i++) {
						plus = plus + star2(n/3)[j%3];
					}
				} else {
					for(int i = 0 ; i < 3 ; i++) {
						plus = plus + star1(n/3)[j%3];
					}
				}

				star[j] = star[j] + plus;
			}

			// 이 다음에 줄바꿈
			return star;
		}
	}

	private static String[] star2(int n) {

		String plus = "";
		String[] star = new String[n];

		if (n==3) {
			star[0] = "* *";
			star[1] = "* *";
			star[2] = "* *";
			return star;
		} else {
			for (int j = 0 ; j < n/3 ; j++) {

				star[j] = "";
				plus = "";

				if ((j+1)%3!=2) {

					plus = plus + star1(n/3)[j%3];

					if (j > n/9 && j < n/9 + n/3) {
						for (int i = 0 ; i < n/3 ; i++) {
							plus = plus + " ";
						}
					} else {
						plus = plus + star1(n/3)[j%3];
					}
					plus = plus + star1(n/3)[j%3];

				} else {
					plus = plus + star2(n/3)[j%3];

					for (int i = 0 ; i < n/3 ; i++) {
						plus = plus + " ";
					}
					plus = plus + star2(n/3)[j%3];
				}

				star[j] = star[j] + plus;
			}

			// 이 다음에 줄바꿈
			return star;
		}
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(star2(n)[1]);

		sc.close();
	}
}
