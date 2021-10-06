import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GoingUpstairs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int[] stairs = new int[301];
		int[] cnt = new int[301];
		for(int i=0;i<n;i++) {
			stairs[i]=Integer.parseInt(br.readLine());
		}
		br.close();
    
    // 차근차근 점화식 찾고 초기 조건 
		cnt[0] = stairs[0];
		cnt[1] = cnt[0]+stairs[1];
		cnt[2] = Math.max(stairs[0]+stairs[2], stairs[1]+stairs[2]);
		for(int i=3;i<n;i++) {
			cnt[i] = Math.max(cnt[i-2]+stairs[i], stairs[i-1]+stairs[i]+cnt[i-3]);
			// 막 두 칸 뛰어넘어서 온 경우는 두 칸 전까지의 값에 지금 계단 더해주기만 하면 됨
			// 한 칸만 뛰어넘는 경우는 최근 연속 두 칸을 밟게 되므로 전전칸은 밟을 수 없었음
			// 그러므로 최근 연속 두개 계단의 값에 전전전계단 값을 더해주면 됨
		}
		bw.write(cnt[n-1]+"\n");
		bw.flush();
		bw.close();
	}
}
