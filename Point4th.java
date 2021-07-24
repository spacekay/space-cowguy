import java.util.Scanner;

public class Point4th {
	public static void main(String[] args) {
		int[] a = new int[3];
		int[] b = new int[3];
		int x = 0;
		int y = 0;
		int ta = 0;
		int tb = 0;
		int mina = 1000;
		int minb = 1000;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0 ; i < 3 ; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			
			if (mina >= a[i]) {
				mina = a[i];
			}
			if (minb >= b[i]) {
				minb = b[i];
			}
			
			if (i > 0) {
				if (a[i] == a[i-1]) {
						y = Math.abs(b[i]-b[i-1]);
				} else {
					if (b[i] == b[i-1]) {
						x = Math.abs(a[i]-a[i-1]);
					} else {
						x = Math.abs(a[i]-a[i-1]);
						y = Math.abs(b[i]-b[i-1]);
					}
				}
			}	
		}
		
		for (int i = 0 ; i < 3 ; i++) {
			if (mina == a[i]) {
				ta++;
			}
			if (minb == b[i]) {
				tb++;
			}
		}
		
		if (ta == 2) {
			System.out.print(mina+x + " ");
		} else {
			System.out.print(mina + " ");
		}
		if (tb == 2) {
			System.out.print(minb+y);
		} else {
			System.out.print(minb);
		}
		
		System.out.println();
		
		sc.close();
	}
}
