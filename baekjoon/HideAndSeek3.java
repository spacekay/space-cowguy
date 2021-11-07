import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek3 {
	static int max = 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());				
		br.close();
		System.out.println(BFS(n,k)+"\n");		
	}	
	private static int BFS(int n, int k) {
		// 아래쪽 visit하는 순서에 따라 자동으로 우선순위가 분류됨
		// 일반 Queue 사용 가능 (물론 Priority Queue 사용하는 방법도 좋음)
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
		boolean[] visit = new boolean[max+1];
		visit[n]=true;
		while(!q.isEmpty()) {
			Node now = q.poll();
			int pos = now.pos;
			int cnt = now.cnt;
			if(pos==k)
				return cnt;
			// 가중치 낮은 쪽을 먼저 가야 함
			if(pos*2<=max&&!visit[pos*2]) {
				q.offer(new Node(pos*2, cnt));
        // 방문처리 한 것이 아래쪽 코드 진행에 즉각적으로 영향을 미침
				visit[pos*2]=true;
			}
			if(pos-1>=0&&!visit[pos-1]) {
				q.offer(new Node(pos-1, cnt+1));
				visit[pos-1]=true;
			}
			if(pos+1<=max&&!visit[pos+1]) {
				q.offer(new Node(pos+1, cnt+1));
				visit[pos+1]=true;
			}
		}
		return 0;
	}
	static class Node {
		int pos;
		int cnt;
		public Node(int a, int b) {
			pos=a;
			cnt=b;
		}
	}
}
