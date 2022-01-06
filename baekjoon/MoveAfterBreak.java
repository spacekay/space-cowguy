import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MoveAfterBreak {
  
	static Queue<Point2206> q = new LinkedList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] maze;
	static int[][][] distance;
	static int n;
	static int m;
	static int min = 1000001;
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		distance = new int[n][m][2];
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			for(int j=0;j<m;j++) {
				if(line.charAt(j)=='1') {
					maze[i][j]=1;
				} 
			}
		}
		br.close();
		
		if(n==1 && m==1) {
			min = 1;
		} else {
			q.offer(new Point2206(0,0,0));
			distance[0][0][0]++;
			BFS();
		}

		if(min>1000000)
			bw.write("-1\n");
		else
			bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
  
	public static void BFS() {

		while(!q.isEmpty()) {
			Point2206 v=q.poll();
			int x=v.x;
			int y=v.y;
			int z=v.z;

			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					// distance array로 방문처리를 겸함
					if(maze[nx][ny]==0 && distance[nx][ny][z]==0) {
						distance[nx][ny][z]=distance[x][y][z]+1;
						if(nx==n-1 && ny==m-1) {
							min = Math.min(min, distance[nx][ny][z]);
							return;
						}
						q.offer(new Point2206(nx, ny, z));
					} else if(z==0 && distance[nx][ny][z]==0) {
						// 벽을 뚫는 순간을 0층에서 1층으로 올라가는 것으로 비유하여 풀이
						distance[nx][ny][1]=distance[x][y][0]+1;;
						q.offer(new Point2206(nx, ny, 1));
					}
				}
			}
		}
	}
}

class Point2206 {
	int x;
	int y;
	int z;

	public Point2206(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
