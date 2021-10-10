import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class RGColorWeakness {
	static Queue<Point10026> q = new LinkedList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] maze;
	static boolean[][] visitedNon;
	static boolean[][] visited;
	static boolean[][] visitedB;
	static int n;
	static int cntNon=0;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());	
		maze = new int[n][n];
		visitedNon = new boolean[n][n];
		visited = new boolean[n][n];
		visitedB = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<n;j++) {
				// 알고리즘이 다 맞는거 같은데 안되면 입력이 정확한지 확인해보자.
				if(line.charAt(j)=='R') {
					maze[i][j]=1;
				} else if(line.charAt(j)=='G') {
					maze[i][j]=-1;
				}
			}
		}
		br.close();		
		for(int i=0;i<n;i++) {			
			for(int j=0;j<n;j++) {
				if(!visitedNon[i][j]&&maze[i][j]==1) {
					BFSR(i,j);
				} else if(!visitedNon[i][j]&&maze[i][j]==-1) {
					BFSG(i,j);
				}
				if(!visited[i][j]&&maze[i][j]!=0) {
					BFS(i,j);
				}
				if(!visitedB[i][j]&&maze[i][j]==0) {
					BFSB(i,j);
				}
			}
		}	
		bw.write(cntNon+" "+cnt+"\n");
		bw.flush();
		bw.close();
	}
	public static void BFSR(int a, int b) {
		cntNon++;
		Queue<Point10026> q = new LinkedList<>();
		q.offer(new Point10026(a,b));
		visitedNon[a][b]=true;
		while(!q.isEmpty()) {
			Point10026 v=q.poll();
			int x=v.x;
			int y=v.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(maze[nx][ny]==1 && !visitedNon[nx][ny]) {
						q.offer(new Point10026(nx,ny));
						visitedNon[nx][ny]=true;
					}
				}
			}
		}
	}
  // 전반적으론 미로 찾기 문제의 코드 기반으로 다듬었음
	public static void BFSG(int a, int b) {
		cntNon++;
		Queue<Point10026> q = new LinkedList<>();
		q.offer(new Point10026(a,b));
		visitedNon[a][b]=true;
		while(!q.isEmpty()) {
			Point10026 v=q.poll();
			int x=v.x;
			int y=v.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(maze[nx][ny]==-1 && !visitedNon[nx][ny]) {
						q.offer(new Point10026(nx,ny));
						visitedNon[nx][ny]=true;
					}
				}
			}
		}
	}
	public static void BFS(int a, int b) {
		cnt++;
		Queue<Point10026> q = new LinkedList<>();
		q.offer(new Point10026(a,b));
		visited[a][b]=true;
		while(!q.isEmpty()) {
			Point10026 v=q.poll();
			int x=v.x;
			int y=v.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(maze[nx][ny]!=0 && !visited[nx][ny]) {
						q.offer(new Point10026(nx,ny));
						visited[nx][ny]=true;
					}
				}
			}
		}
	}
	public static void BFSB(int a, int b) {
		cnt++;
		cntNon++;
		Queue<Point10026> q = new LinkedList<>();
		q.offer(new Point10026(a,b));
		visitedB[a][b]=true;
		while(!q.isEmpty()) {
			Point10026 v=q.poll();
			int x=v.x;
			int y=v.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(maze[nx][ny]==0 && !visitedB[nx][ny]) {
						q.offer(new Point10026(nx,ny));
						visitedB[nx][ny]=true;
					}
				}
			}
		}
	}
}

class Point10026 {
	int x;
	int y;
	public Point10026(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
