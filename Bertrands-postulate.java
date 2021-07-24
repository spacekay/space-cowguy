package primenumber;

import java.util.Scanner;

public class N1929 { // 에라토스테네스의 체로 만든 알고리즘 활용

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 1;
		
		do {
		n = sc.nextInt();
		
		if (n == 0)
			break;
		
		int t = 0;
		
		boolean[] prime = new boolean[2*n+1];

		prime[0] = true;

		for (int j = 2 ; j <= 2*n ; j++) {
			for (int k = 2 ; k*j <= 2*n ; k++) { 
				prime[j*k] = true;
			}
		}
		
      //문제의 조건을 정확히 읽어야 한다 (n보다 크다 or 크거나 같다)
		for (int i = n+1 ; i <= 2*n ; i++) {
			if (prime[i] == false && i != 1)
				t++;
		}
		
		System.out.println(t);
		} while (n != 0);
		sc.close();
	}
}
