import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato3D {
	static Queue<Tomato1> bfs;
	static int[][][] conn;
	static int n;
	static int m;
	static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		conn = new int[m][n][h];
		bfs=new LinkedList<>();
		for(int k=0;k<h;k++) {
			for (int j=0;j<n;j++) {
				// br.readLine().split(" ")보다 StringTokenizer가 훨씬 빠르다.
				st = new StringTokenizer(br.readLine()," ");
				for(int i=0;i<m;i++) {
					conn[i][j][k]=Integer.parseInt(st.nextToken());
					if(conn[i][j][k]==1)
						bfs.offer(new Tomato1(i,j,k));
				}
			}
		}
		bw.write(BFS()+"\n");
		br.close();
		bw.flush();
		bw.close();

	}
	public static int BFS() {
		int result=0;
		int[] dx = {1,0,0,-1,0,0};
		int[] dy = {0,1,0,0,-1,0};
		int[] dz = {0,0,1,0,0,-1};
		while(!bfs.isEmpty()) {
			Tomato1 v=bfs.poll();
			int x=v.x;
			int y=v.y;
			int z=v.z;
			for(int i=0;i<6;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				int nz=z+dz[i];
				if(nx>=0&&ny>=0&&nz>=0&&nx<m&&ny<n&&nz<h) {
					if(conn[nx][ny][nz]==0) {
						bfs.add(new Tomato1(nx,ny,nz));
						conn[nx][ny][nz]=conn[x][y][z]+1;
					}
				}
			}
		}
		for(int k=0;k<h;k++) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(conn[i][j][k]==0)
						return -1;
					result=Math.max(result, conn[i][j][k]);
				}
			}
		}
		return result-1;
	}
}
class Tomato1 {
	int x;
	int y;
	int z;
	public Tomato1 (int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
