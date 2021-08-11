import java.util.Scanner;

public class Turret {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] x = new int[6];
		int n = sc.nextInt();
		int p = 0;

		for (int j = 0 ; j < n ; j++) {

			for (int i = 0 ; i < 6 ; i++) {
				x[i] = sc.nextInt();
			}

			double l = Math.sqrt((Math.pow(x[0]-x[3],2)+Math.pow(x[1]-x[4],2)));
			double abr = Math.abs(x[2]-x[5]);

			if (l > x[2] && l > x[5]) {
				if (l < x[2]+x[5]) {
					p = 2;
				} else if (l == x[2]+x[5]) {
					p = 1;
				} else {
					p = 0;
				}
			} else if (x[0] == x[3] && x[1] == x[4] && x[2] == x[5]) {
				p = -1; //예외 조건 처리에 유의한다.
			} else {
				if (l > abr) {
					p = 2;
				} else if (l == abr) {
					p = 1;
				} else {
					p = 0;
				}
			}

			System.out.println(p);

		}

		sc.close();
	}

}
