package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachsConjecture {

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// output을 자주 하는 경우 OutputStreamWriter의 장점을 살리기 어려울 수 있음
		// 데이터가 많아질 때 테스트 해보면 좋을듯

		int x = (int) Math.sqrt(1000000);
		boolean[] prime = new boolean[1000001];

		prime[0] = true;
		prime[1] = true;

		for (int j = 2 ; j <= x ; j++) {
			for (int k = 2 ; k*j <= 1000000 ; k++) { 
				prime[j*k] = true;
			}
		}

		boolean run = true;

		while (run)  {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				run = false;
				System.out.println(sb);
				break;
			}

			boolean flag = false;

			for (int j = 3 ; j <= n/2 ; j += 2) {
				if(!prime[j] && !prime[n-j]) {
					sb.append(n+" = "+j+" + "+(n-j)).append("\n");
					flag = true;
					break;
				}
			}

			if (!flag) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}			
		}
		br.close();
	}
}
