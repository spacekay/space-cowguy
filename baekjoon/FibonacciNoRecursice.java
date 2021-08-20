import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciNoRecursice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int[] a = new int[41];
		int[] b = new int[41];
  
    // 재귀함수는 스피드가 중요한 연산에서는 피한다.
    // 최대한 다른 방향의 규칙성도 생각한다.
    // 스피드 구현에 여유가 있는 언어라면 Dynamic Programming 참조!
		while (t --> 0) {
			int n = Integer.parseInt(br.readLine());
			a[0] = 1; b[0] = 0;
			a[1] = 0; b[1] = 1;
			for (int i = 2 ; i < n+1 ; i++ ) {
				a[i] = a[i-1] + a[i-2];
				b[i] = b[i-1] + b[i-2];	
			}		
			bw.write(a[n]+" "+b[n]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
