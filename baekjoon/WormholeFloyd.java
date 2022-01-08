import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WormholeFloyd {
	static int[][] arr;
	static final int MAX = 1000_0001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int l=0;l<T;l++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr = new int[n+1][n+1];
			for(int i=0;i<n+1;i++) {
				Arrays.fill(arr[i], MAX);
			}
			
			int x = -1;
			int y = -1;
			int t = -1;
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				arr[x][y] = Math.min(t, arr[x][y]);
				arr[y][x] = Math.min(t, arr[y][x]);		
			}

			for(int i=0;i<w;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				arr[x][y] = Math.min(-t, arr[x][y]);
			}
			
			for(int i=1;i<n+1;i++)
				for(int j=1;j<n+1;j++)
					for(int k=1;k<n+1;k++) {
						// i를 거쳐가는 비용과 현재 비용 중 더 저렴한 경우를 계속 선택함
						if(arr[j][k] > arr[j][i]+arr[i][k]) {
							arr[j][k] = arr[j][i]+arr[i][k];
						}
					}
			
			boolean flag = false;
			
			for(int i=1;i<n+1;i++) {
				if(arr[i][i]<0) {
					flag = true;
					break;
				}
			}
			
			if(flag)
				bw.write("YES\n");
			else
				bw.write("NO\n");		
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
