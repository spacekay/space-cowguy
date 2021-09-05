import java.io.*;
import java.util.Scanner;

public class One {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
    // 굳이 k를 BigInteger를 사용하지 않고 연산할 수 있는 방법을 찾자.
		// 어떤 정수의 나머지의 약수는 그 정수의 약수이기도 하다.
		int k, t; 
		while (sc.hasNextInt()) {
			n = sc.nextInt();
			// t와 k가 0인 경우는 판정할 필요가 없음
			// (1보다 큰 수로 1일 나누어질 리가 없음)
			t = 1;
			k = 1;
			// 이전 반복에서의 결과를 가지고 판정
			while (k%n != 0) {
        // k가 int 범위를 넘지 않도록 조절 가능
				k = (k*10+1)%n;
				t++;
			}
			bw.write(t+"\n");
		}
		sc.close();
		bw.flush();
		bw.close();
	}
}
