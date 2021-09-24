import java.io.*;
import java.util.*;
class CountAreaBFS {
	static Queue<Point> q=new LinkedList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt;
	static int n;
	static boolean[][] conn;
	static boolean[][] checked;
	static PriorityQueue<Integer> list = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		conn = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				if(line[j].charAt(0)=='1') {
					conn[i][j]=true;
				}
			}
		}
		br.close();
		checked=new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!checked[i][j]&&conn[i][j])
					BFS(i,j);
			}
		}
		bw.write(cnt+"\n");
		while(!list.isEmpty()) {
			bw.write(list.poll()+" ");
		}
		bw.flush();
		bw.close();
	}
	
	public static void BFS (int a, int b) {
		int local=0;
		q.offer(new Point(a,b));
		checked[a][b]=true;
		while(!q.isEmpty()) {
			Point p=q.poll();
			local++;
			int x=p.x;
			int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(conn[nx][ny] && !checked[nx][ny]) {
						q.offer(new Point(nx, ny));
						checked[nx][ny]=true;
					}
				}
			}
		}
		cnt++;
		list.offer(local);
	}
}
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
