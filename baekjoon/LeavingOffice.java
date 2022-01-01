import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LeavingOffice {
	static int[][] save;
	static int n;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		n = Integer.parseInt(br.readLine());
		save = new int[n+1][2];
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			save[i][0] = Integer.parseInt(st.nextToken());
			save[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();

		for(int i=1;i<=n;i++) {
			DFS(i, save[i][1]);
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}

	static void DFS(int day, int sum) {
		// n번째 날에도 1일 걸리는 일은 할 수 있음
		if(day+save[day][0]<=n+1) {
			max = Math.max(max, sum);
		}

		for(int i=day+save[day][0];i<=n;i++) {
			DFS(i, sum+save[i][1]);
		}
	}

}
