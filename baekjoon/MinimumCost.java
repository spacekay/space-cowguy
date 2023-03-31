import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimumCost {
	static int[][] bus;
	static int n;
	static int m;
	static boolean[] visited;
	static long[] cost;
	static int inf = 1000000000; // 데이터 입력값 규모에 따라 inf는 넉넉하게 조절한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		bus = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(bus[i], inf);
		}
		StringTokenizer st;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(bus[a][b]==inf) {
				// 이 문제는 양방향 아님에 주의. 출발점과 도착점이 정해져 있음
				bus[a][b]=cost;
			} else if(cost<bus[a][b]) {
				bus[a][b]=cost;
			}				
		}
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		br.close();
		minCost(a,b);
		bw.write(cost[b]+"\n");
		bw.flush();
		bw.close();
	}
  // Dijkstra algorithm 사용법 익힘! (가중치가 음수가 아닐 때에 탐색하는 방법 -> 최소값을 갱신)
	public static void minCost(int a, int b) {		
		visited = new boolean[n+1];
		cost = new long[n+1];
		Arrays.fill(cost, inf);
		
		// 출발지와 목적지가 같은 경우에는 버스를 타지 않아도 됨
		if (a == b) {
			cost[b] = 0;
			return;
		}
		
		for(int i=1;i<=n;i++) {
			cost[i]=bus[a][i];
		}
		visited[a]=true;
		
		// 전체 도시에 대해서 네트워크를 탐색해야 하므로 안전하게는 n회 탐색이 필요하다.
		// 반복문 작성 오류가 '틀렸습니다' 원인인 것으로 추정
		for(int i=0;i<n-1;i++) {
			int now = minIndex();
			visited[now]=true;
			
			// 버스 번호와 array index를 동일하게 맞춰 놓았기 때문에 반복문 범위를 1 to n으로 설정
			for(int j=1;j<=n;j++) {
				if(!visited[j]) { // 최소값으로 갱신해주기
					if(cost[now]+bus[now][j]<cost[j]) {
						cost[j]=cost[now]+bus[now][j];
					}
				}
			}
		}
	}
	public static int minIndex() {
		int index=0;
		long min= inf + 1;
		for(int i=1;i<=n;i++) {
			if(cost[i]<min && !visited[i]) {
				min = cost[i];
				index = i;
			}
		}		
		return index;
	}
}
