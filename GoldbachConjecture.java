package primenumber;

import java.util.Scanner;

public class GoldbachConjecture {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n, m;

		while ( t > 0 ) {
			t--;
			n = sc.nextInt();

			if (n == 0)
				break;

			boolean[] prime = new boolean[n+1];

			prime[0] = true;
			prime[1] = true;

			for (int j = 2 ; j <= n ; j++) {
				for (int k = 2 ; k*j <= n ; k++) { 
					prime[j*k] = true;
				}
			}
      
      // while이나 for을 쓸 때 breakpoint를 잡는 것이 중요하다. + 가능한 모든 경우에 대해 test하기
      // 두 수 모두 소수여야 한다는 점을 확인하여야 한다.
			for (int i = n/2 ; i > 1 ; i--) {
				if (prime[i] == false && prime[n-i] == false) {
					m = n-i;
					System.out.print(i+" "+m+"\n");
					break;
				}
			}
		}

		sc.close();
	}
}
