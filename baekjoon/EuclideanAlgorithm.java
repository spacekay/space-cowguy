import java.util.Scanner;

public class EuclideanAlgorithm { // 유클리드 호제법을 직접적으로 참조한 것은 아니지만 결국 원리가 녹아있긴 한듯

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int M = Math.max(a, b);
		int N = Math.min(a, b);
		long minNum;
		
		if (M%N != 0)
			minNum = minNumGet(a, b);
		else
			minNum = N;
		long maxNum = a*b/minNum;
		
		System.out.println(minNum);
		System.out.println(maxNum);
		
		sc.close();
	}
	
	public static long minNumGet(int n1, int n2) {
		long N = 1;
		int M = Math.max(n1, n2);
		boolean[] prime = new boolean[M+1]; // 기본값 false

		prime[0] = true;
		prime[1] = true;

		for (int j = 2 ; j <= M ; j++) {
			for (int k = 2 ; k*j <= M ; k++) { 
				prime[j*k] = true;
			}
		}
		
		for (int i = 2 ; i <= M ; i++) {
			if (!prime[i]) { // 소수로만 진행해야 소인수분해 역방향 계산이 가능
				if (n1%i == 0 && n2%i == 0) {
					N *= i;
					n1 /= i;
					n2 /= i;
					
					if (n1 == 1 || n2 == 1) // 더이상 n1이나 n2를 나눌 수 없다면 반복문을 끝내야 함
						break;
					i = 1;
					continue; // 같은 소수로 여러번 나눌 수 있어야 함
				}
			}
		}	
		return N;
	}
}
