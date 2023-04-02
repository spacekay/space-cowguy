import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SojangGround {
  
	// 플로이드워셜로 수정
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] item = new int[n + 1];
		Arrays.fill(item, 0);

		st = new StringTokenizer(br.readLine());

		int[][] path = new int[n + 1][n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(path[i], 10000000);
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			path[s][e] = length;
			path[e][s] = length;
		}
		
		br.close();
    
		// 플로이드 워셜로 도전 (경유지를 지나는 것이 기존의 거리보다 더 짧다면 값 갱신)
		for (int k = 1; k < n + 1; k++) { // 경유지
			for (int i = 1; i < n + 1; i++) { // 출발지
				for (int j = 1; j < n + 1; j++) { // 도착지
          // 이 문제에서는 출발지와 도착지가 같은 경우 거리를 무조건 0으로 가정하고 있어, 이동하지 않는 것이 이득이다.
					// i == j, i == k, j == k인 경우에는 이동할 수 없도록 path값 30을 유지해야 함 (path[i][i]는 언제나 30으로
					// 유지하기)
					// 아래 if문을 작성하지 않으면, 탐색이 진행되면서 path[i][i] 값이 무너질 가능성이 있다.
    			if (i == j) {
						continue;
					}
					path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
				}
			}
		}
		
		int max = 0;
		int sum;
		
		// 출발지별로 path가 m보다 같거나 작은 경우에만 도착지의 아이템을 먹음
		for(int i=1;i<n+1;i++) {
			sum = item[i];
			for(int j=1;j<n+1;j++) {
				if(path[i][j] <= m) {
					sum += item[j];
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
