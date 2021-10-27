import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 출력값 관련 뻘짓을 너무 오래하는 과정에서 다익스트라 코드 구조를 거의 외운 것 같다.
// 그래도 내가 뭘 잘못했지..ㅠ 하는 과정이 매우 슬펐다... 조금이라도 일찍 찾아서 다행 ㅠㅠ
public class ShortestRoute {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = 100_000_000;
	static int n,m,k;
	static List<Node>[] arrs;
	static int[] cost;
	public static void main(String[] args) throws IOException {
		 StringTokenizer st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(br.readLine());
			cost = new int[n+1];
			Arrays.fill(cost, INF);
			arrs = new ArrayList[n+1];
			for(int i=1;i<=n;i++) {
				arrs[i]=new ArrayList<>();
			}
	        // 리스트에 그래프 정보를 초기화
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arrs[a].add(new Node(b,c));
			}
	        // 다익스트라 알고리즘
	        dijkstra(k);
	        // 출력 부분
	        // 문자 출력은 대소문자 진짜 조심하자... 나 눈물난다 ㅠㅠ
	        for(int i=1;i<=n;i++) {
				if(cost[i]==INF)
					bw.write("INF\n");
				else
					bw.write(cost[i]+"\n");
			}
	        bw.close();
	        br.close();
	}
	private static void dijkstra(int start){
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start,0));
		boolean[] visited = new boolean[n+1];
		cost[start]=0;

		while(!q.isEmpty()){
			Node curNode = q.poll();
			int cur = curNode.arrive;

			if(visited[cur] == true) continue;
			visited[cur] = true;

			for(Node node : arrs[cur]){
				if(cost[node.arrive] > cost[cur] + node.cost){
					cost[node.arrive] = cost[cur] + node.cost;
					q.add(new Node(node.arrive, cost[node.arrive]));
				}
			}
		}
	}
	static class Node implements Comparable<Node> {
		int arrive;
		int cost;
		Node(int arrive, int cost) {
			this.arrive = arrive;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
