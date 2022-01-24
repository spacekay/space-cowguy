import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		br.close();
		// 1자리를 0으로, n자리를 n-1로 처리함
		long[][] cnt = new long[90][2];
		cnt[0][0] = 0;
		cnt[0][1] = 1;
		for(int i=1;i<n;i++) {
			cnt[i][0] = cnt[i-1][0] + cnt[i-1][1];
			cnt[i][1] = cnt[i-1][0]+1;
			// cnt[i][0]은 해당 자리에 0이 오는 경우까지의 가짓수
			// cnt[i][1]은 해당 자리에 1이 오는 경우까지의 가짓수
		}
		System.out.println(cnt[n-1][1]);
	}
}
