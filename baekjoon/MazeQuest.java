import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeQuest {
	static Queue<Point2178> q = new LinkedList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] maze;
	static boolean[][] visited;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<m;j++) {
				if(line.charAt(j)=='1') {
					maze[i][j]=1;
				} 
			}
		}
		br.close();
		q.offer(new Point2178(0,0));
		visited[0][0]=true;
		BFS();
		bw.write(maze[n-1][m-1]+"\n");
		bw.flush();
		bw.close();
	}
	public static void BFS() {
		while(!q.isEmpty()) {
			Point2178 v=q.poll();
			int x=v.x;
			int y=v.y;
			//System.out.println(x+", "+y);
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					// visited 표시 안해주면 뱅뱅 돌 수도 있음
					// 탐색 진행 방향을 한 번도 가지 않은 쪽으로 잡아주려면 필수
					if(maze[nx][ny]>0 && !visited[nx][ny]) {
						q.offer(new Point2178(nx,ny));
						maze[nx][ny]=maze[x][y]+1;
						visited[nx][ny]=true;
						if(nx==n-1 && ny==m-1) {
							return;
						}
					}
				}
			}
		}
	}
}
class Point2178 {
	int x;
	int y;
	public Point2178(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
