// 재귀함수 코드 구현법 이해하기 시작함

import java.util.Scanner;

public class Main {
	
	private static int Fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n > 1)
			return (Fib(n-1)+Fib(n-2));
		else
			return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		System.out.println(Fib(x));
		
		sc.close();

	}

}
