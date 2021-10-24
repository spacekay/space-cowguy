import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HanoiTower {
	static int cnt=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();
		moveDisk(n,1,2,3);
		bw.write(cnt+"\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	public static void moveDisk(int n, int start, int mid, int to) {
		cnt++;
		if(n==1) {
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}
		// 맨 끝에 n개를 얹으려면 n-1개를 중앙에 얹어놔야 함
		moveDisk(n-1,start,to,mid);
		// 그러고 가장 큰 원반을 오른쪽으로 옮김
		sb.append(start).append(" ").append(to).append("\n");
		// 그다음 중앙에 쌓인 n-1개를 다시 그 위에 옮김
		moveDisk(n-1,mid,start,to);
	} 
}
