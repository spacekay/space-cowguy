import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage {
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int m=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			Point1012[][] conn = new Point1012[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					conn[i][j]=new Point1012(j, i, 0);			
				}
			}
			for(int i=0;i<k;i++) {
				st=new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				conn[y][x].t=1;	
			}	
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(!conn[i][j].flag&&conn[i][j].t!=0) {
						conn=BFS(conn,j,i);			
					}
				}
			}
			bw.write(cnt+"\n");
			cnt=0;
		}
		br.close();
		bw.flush();
		bw.close();
	}
  
  // 기존에 가지고 있던 로직 기반으로 조건에 맞게 
	private static Point1012[][] BFS(Point1012[][] conn, int x, int y) {
		cnt++;
		Queue<Point1012> bfs = new LinkedList<>();
		conn[y][x].flag=true;
		bfs.add(conn[y][x]);
		while (!bfs.isEmpty()) {
			Point1012 v = bfs.poll();
			int pX=v.x;
			int pY=v.y;
      // 아래부분 좀더 단순하게 할 방법 고민하기
			if(pX<conn[0].length-1) {
				if(conn[pY][pX+1].t==1 && !conn[pY][pX+1].flag) {
					conn[pY][pX+1].flag=true;
					bfs.offer(conn[pY][pX+1]);
				}
			}
			if(pX>0) {
				if(conn[pY][pX-1].t==1 && !conn[pY][pX-1].flag) {
					conn[pY][pX-1].flag=true;
					bfs.offer(conn[pY][pX-1]);
				}
			}
			if(pY<conn.length-1) {
				if(conn[pY+1][pX].t==1 && !conn[pY+1][pX].flag) {
					conn[pY+1][pX].flag=true;
					bfs.offer(conn[pY+1][pX]);
				}
			}
			if(pY>0) {
				if(conn[pY-1][pX].t==1 && !conn[pY-1][pX].flag) {
					conn[pY-1][pX].flag=true;
					bfs.offer(conn[pY-1][pX]);
				}
			}
		}
		return conn;
	}
}

class Point1012 {
	int x;
	int y;
	int t;
	boolean flag=false;
	public Point1012 (int x, int y, int t) {
		this.x=x;
		this.y=y;
		this.t=t;
	}
}
