import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft {

	static Queue<Integer> order;
	static int[] edge;
	static int[] time;
	static int[] state;
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int k=0;k<T;k++) {
			order = new LinkedList<>();
			graph= new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// 위상정렬을 위한 배열. 아직 탐색하지 않은 간선(에지) 개수를 나타냄
			edge = new int[n+1];
			
			// 각 건물 건축 시간
			time = new int[n+1];
			
			// 각 건물을 지을 때까지 누적된 최대 시간 (이전까지 지어야 하는 모든 건물들 짓고 난 시간)
			state = new int[n+1];

			st = new StringTokenizer(br.readLine()," ");
			graph.add(new ArrayList<>());
			for(int i=1;i<n+1;i++) {
				graph.add(new ArrayList<>());
				time[i] = Integer.parseInt(st.nextToken());
			}

			for(int l=0;l<m;l++) {
				st = new StringTokenizer(br.readLine()," ");
				int prev = Integer.parseInt(st.nextToken());
				int now = Integer.parseInt(st.nextToken());
				graph.get(prev).add(now);
				edge[now]++;
			}

			int target = Integer.parseInt(br.readLine());

			int tm = TopologySort(target);
			bw.write(tm+"\n");
		}
		bw.flush();
		bw.close();
	}

	static int TopologySort(int target) {
		for(int i=1;i<n+1;i++) {
			if(edge[i]==0) {
				order.add(i);
				state[i] = time[i];
			}
		}

		// 전체 건물의 수만큼 반복
		for(int i=0;i<n;i++) {
			int now = order.poll();

			for(int next : graph.get(now)) {
				// 현재까지 이 간선에 도착하는데 걸린 최대 요구시간을 두 조건 중 찾아 대체함
				state[next] = Math.max(state[now]+time[next], state[next]);
				
				edge[next]--;
				// 더이상 이 간선 앞에 있는 것이 없는 경우, 이 간선에 달려있는 것들을 새롭게 탐색
				if(edge[next]==0) {
					order.add(next);			
				}
			}
		}

		return state[target];
	}
}
