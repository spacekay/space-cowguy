import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sticker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());	
		for(int k=0;k<K;k++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
      // 
			int[][] max = new int[3][n];
			StringTokenizer st;
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			max[0][0] = arr[0][0];
			max[1][0] = arr[1][0];
			
			for(int i=1;i<n;i++) {
				// 윗줄 스티커를 떼기 위해서는 전 칸에서 아래줄을 떼었거나 아예 떼지 않았어야 함
				max[0][i] = Math.max(max[1][i-1], max[2][i-1])+arr[0][i];
				// 아랫줄 스티커를 떼기 위해서는 전 칸에서 윗줄을 떼었거나 아예 떼지 않았어야 함
				max[1][i] = Math.max(max[0][i-1], max[2][i-1])+arr[1][i];
				// 이번 칸 스티커를 떼지 않되 최대값을 유지하려면, 이전 칸에선 스티커를 반드시 하나는 떼었다고 가정해야 함
				max[2][i] = Math.max(max[1][i-1], max[0][i-1]);
			}
			bw.write(Math.max(Math.max(max[0][n-1], max[1][n-1]), max[2][n-1])+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
