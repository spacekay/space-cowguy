// 재귀함수로 풀라고 했는데 그냥 풀었다..
// 이후 문제부터는 재귀함수 활용법 확인하여 풀이함.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long fac = 1;
		
		for (int i = 1 ; i <= n ; i++) {
			fac *= i;
		}
		
		System.out.println(fac);
		
		sc.close();

	}
}
