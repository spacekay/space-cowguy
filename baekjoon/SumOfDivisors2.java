package math0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumOfDivisors2 {
	static long[] sum;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
    // n 이하의 수에 대해서만 누적합을 구하면 충분함
    int n = Integer.parseInt(br.readLine());
		br.close();
		
		sum = new long[n+1];

		for(int i=1;i<n+1;i++) {
			// index들 자체를 더해버리는 식으로 구현
			// i는 i*k=n의 약수이므로, 모든 n에게 i를 미리 더해주는 식으로 구현
			// ex : 5, 10, 15, 20, 25, ... 에게 모두 5씩 미리 더해줌
			for(int j=i;j<n+1;j+=i) { // 이전 코드 기준 now를 구현하는 식
				sum[j] += i;
			}
			// 마지막에 누적합으로 처리
			sum[i] += sum[i-1];
		}
		
		bw.write(sum[n]+"\n");

		bw.flush();
		bw.close();
	}
}
