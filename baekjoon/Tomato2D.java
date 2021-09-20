import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato2D {
	static Queue<Tomato> bfs;
	static int[][] conn;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		conn = new int[n][m];
		String[] line;
		bfs=new LinkedList<>();
		for (int i = 0 ; i<n ; i++) {
			line=br.readLine().split(" ");
			for(int j=0; j<m;j++) {
				int point=Integer.parseInt(line[j]);
				conn[i][j]=point;
				// 1인 모든 토마토를 넣어둔다 (level 1)
				if(point==1)
					bfs.add(new Tomato(j,i));
			}
		}
		br.close();
		bw.write(BFS()+"\n");
		bw.flush();
		bw.close();
	}
	public static int BFS() {
		int result=0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		// 좌표 순서대로 1이 나올때만 BFS 돌리는 것보다, 1이 있는 좌표를 수집하여 각각 BFS 돌려주는 것이 좋다.
		// 이렇게 하면 중간에 만나는 케이스에 대해서도 비교적 안전해진다. 어차피 같은 날에 닿으므로 같은 값이 나올테니
		// BFS로 하면 하루마다 퍼지는 범위를 구현하는 데에 용이하다. (DFS는 각각의 점에서 가는데 걸리는 시간 비교 같은거)
		while(!bfs.isEmpty()) { // 한 번 돌릴 떄마다 level이 1씩 증가함
			Tomato v=bfs.poll();
			int x=v.x;
			int y=v.y;
			for(int i=0;i<4;i++) {
				// 4번 돌 때마다 상하좌우를 한 번씩 확인 가능
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
					if(conn[ny][nx]==0) {
						bfs.add(new Tomato(nx,ny));
						conn[ny][nx]=conn[y][x]+1;
					}

				}
			}
		}
		// boolean으로 전 지점 검사하면 좀 더 속도 빠르고 메모리 점유도 적긴 할 것
		// 아이디어 : 1은 true로 하고 queue에 넣음, -1은 true로만 함, 0은 false로 함
		// 이후 절차는 false인 노드에 대해서만 함 (어차피 -1도 있어도 되는 거기 때문에)
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(conn[i][j]==0)
					return -1;
				result=Math.max(result, conn[i][j]);
			}
		}
		// 최초 시작 날짜 1만큼 빼야 함
		return result-1;
	}
}

class Tomato {
	int x;
	int y;
	public Tomato (int x, int y) {
		this.x=x;
		this.y=y;
	}
}
