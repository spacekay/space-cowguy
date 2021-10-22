import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Tetromino {
	static long max=0;
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int m;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int nowI;
	static int nowJ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited= new boolean[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				nowI=i;
				DFS(i,j,0,0);
				crossCheck(i,j);
			}
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
  // 아이디어 자체는 충분하다. ㅗㅓㅏㅜ 제외하고 나머지는 DFS로 표현 가능함을 찾았다.
	public static int DFS(int x, int y, int sum, int depth) {
		if(depth==4) {
			if(max<sum)
				max=sum;
			return sum;
		} else {
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<n&&ny<m&&nx>=0&&ny>=0) {
					// 방문 기록 안하면 같은 곳을 빙빙 돌기도 한다.
					// 경로 진행 중에는 이전에 지나온 곳은 안 가게 해야 한다.
					if(!visited[nx][ny]) {
						visited[nx][ny]=true;
						DFS(nx,ny,sum+map[nx][ny],depth+1);
						visited[nx][ny]=false;
					}
				}
			}
		}
		return 0;
	}
	public static int crossCheck(int x, int y) {
		// 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
		// 그런데 min 설정을 7이라는 어마어마하게 작은 수로 하다니!!!
		// 사람이 이렇게 어처구니없는 실수를 할 수 있구나 하고 깨달음을 얻음!
		int min = 10000;
		int cnt=4;
		int newSum=map[x][y];
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<n&&ny<m&&nx>=0&&ny>=0) {
				if(min>map[nx][ny])
					min=map[nx][ny];
				newSum+=map[nx][ny];
			} else
				cnt--;
		}
		// 주변 4개를 모두 활용할 수 없을 수 있다.
		if(cnt==4)
			newSum-=min;
		else if(cnt<3)
			return 0;
		return DFS(x,y,newSum,4);
	}
}
