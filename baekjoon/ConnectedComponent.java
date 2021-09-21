import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ConnectedComponent {
	static Queue<Integer> bfs;
	static boolean[][] conn;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		conn=new boolean[n+1][n+1];
		visited = new boolean[n+1];
		bfs = new LinkedList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			conn[u][v]=true;
			conn[v][u]=true;
		}
		br.close();
		int cnt=0;
		//문제의 조건 상 점의 범위는 1부터 n까지임. for문 작성할 때 주의
		for (int i = 1 ; i<=n ; i++) {
			// 방문하지 않은 모든 점을 일단 한번씩 가게 하면 방문 안한 점 따로 체크할 필요 없음
			// 그거 자체가 connected로 연결되어 있건 아니건 cnt는 올라가므로 true로 초기화 필요없음
				if(!visited[i]) {
					visited[i]=true;
					bfs.add(i);
					BFS();
					cnt++;
				}
		}	
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
	private static void BFS() {
		while (!bfs.isEmpty()) {
			int save = bfs.poll();
			for(int i=1;i<=n;i++) {
				if(conn[save][i]&&!visited[i]) {
					bfs.offer(i);
					visited[i]=true;
				}
			}
		}
	}
}
