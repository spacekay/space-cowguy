import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindRoute {
	static int[][] conn;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		conn = new int[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				conn[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		for(int i=0;i<n;i++) {			
			for(int j=0;j<n;j++) {
				sb.append(BFS(i,j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	// 플로이드 와셜 방법 사용 가능. i->k와 k->j가 모두 1이면 i->j는 1이다
	public static int BFS(int a, int b) {
		Queue<Point11403> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.offer(new Point11403(0,a));
		while(!q.isEmpty()) {
			Point11403 v=q.poll();
			int y=v.y;
			for(int i=0;i<n;i++) {
				if(conn[y][i]==1 && !visited[i]) {
					q.offer(new Point11403(y,i));
					visited[i]=true;
					if(i==b) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
}
class Point11403 {
	int x;
	int y;
	public Point11403(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
