package primenumber;

import java.util.Scanner;

public class PrimeNumberSieve {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		
		// 단순히 true/false를 구분하기 위한 array라면 boolean을 쓰는 게 빨라진다.
		boolean[] prime = new boolean[n+1];

		prime[0] = true;
		prime[1] = true;

		for (int j = 2 ; j <= n ; j++) {
			for (int k = 2 ; k*j <= n ; k++) { 
				// k*j <= n 이런 방식으로도 for문 쓸 수 있음에 대한 발견
				prime[j*k] = true;
			}
		}
		
		// for문이나 if문은 최대한 중첩하지 말자.
		for (int i = m ; i <= n ; i++) {
			if (prime[i] == false)
				System.out.println(i);
		}	
		sc.close();
	}
}
