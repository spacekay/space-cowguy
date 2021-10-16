import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS 함수가 끝없이 돌아간다. 엄청나게 느리고 메모리도 많이 먹을 수밖에 없다.
// 통과된게 신기하다.
// BFS 함수를 하나만 사용하여 매 순간 각 점과의 거리를 측정할 수 있는 알고리즘 구현을 연구해야 할 것 같다.
// 이정도 문제는 답을 보고 풀면 큰 의미가 없을 것 같다.
public class BabyShark {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] space;
	static int n;
	static int result=0;
	static int tmp=0;
	static Queue<Shark> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		space = new int[n][n];
		StringTokenizer st;
		int a=0;
		int b=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				space[i][j]=Integer.parseInt(st.nextToken());
				if(space[i][j]==9) {
					a=i;
					b=j;
				}		
			}
		}
		br.close();
		BFS(a,b,2);		
		bw.write(result+"\n");		
		bw.flush();
		bw.close();
	}
	public static int smallBFS(int a, int b, int c, int d,int shark) {
		boolean[][] visited = new boolean[n][n];
		int[][] time = new int[n][n];
		Queue<Shark> local = new LinkedList<>();
		local.offer(new Shark(a,b));
		
		while(!local.isEmpty()) {
			Shark v=local.poll();
			int x=v.x;
			int y=v.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(space[nx][ny]<=shark && !visited[nx][ny]) {
						local.offer(new Shark(nx,ny));
						time[nx][ny]=time[x][y]+1;
						visited[nx][ny]=true;
						if(nx==c && ny==d) {
							return time[nx][ny];
						}
					}
				}
			}
		}
		return 100000; // 이 부분도 조심해야 함
	}
	public static void BFS(int a, int b, int shark) {
		q = new LinkedList<>();
		//System.out.println(a+"***"+b+": "+shark+" count: "+(cnt)+" shark: "+shark);
		boolean[][] checked = new boolean[n][n];
		int[][] time = new int[n][n];
		q.offer(new Shark(a,b));
		while(!q.isEmpty()) {
			Shark s = q.poll();
			int x = s.x;
			int y = s.y;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(space[i][j]<=shark&&!checked[i][j]) {
						q.offer(new Shark(i,j));
            // time 값을 구하는 로직을 개선해야 한다. 일단 원인을 내가 찾아낸 것은 정말 다행이다.
						time[i][j]=smallBFS(x,y,i,j,shark);
						checked[i][j]=true;
					}
				}
			}
		}
    // 내부 경로가 얼마나 꼬여있냐에 따라 min=100~200 정도로는 충분히 크지 않을 수도 있다.
		int min=10000;
		int minX=-1;
		int minY=-1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(space[i][j]<shark&&space[i][j]>0) {
					if(min>time[i][j]) {
						min=time[i][j];
						minX=i;
						minY=j;
					} 

				}
			}
		}
		if(min==10000) {
			return;
		}
			
		else {
			space[a][b]=0;
			space[minX][minY]=9;
			tmp++;
			if(tmp==shark&&shark<7) {
				tmp=0;
				shark++;
			}
			result+=min;
			BFS(minX,minY,shark);
		}
	}
}
class Shark{
	int x;
	int y;
	public Shark(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
