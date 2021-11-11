import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		// 최대값 범위 확인하여 long으로 바꾸어줌
		long[] arr = new long[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<n+1;i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		bw.write(arr[n]+"\n");
		bw.flush();
		bw.close();
	}
}
