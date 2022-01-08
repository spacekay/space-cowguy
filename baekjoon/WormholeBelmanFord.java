import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Edge>> edge;
	static int[] distance;
	static int n;
	static final int MAX = 1000_0001;
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int l=0;l<T;l++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge = new ArrayList<>();
			distance = new int[n+1];

			for(int i=0;i<n+1;i++)
				edge.add(new ArrayList<>());

			int edges = m+w;

			for(int i=0;i<edges;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());

				if(i<m) {
					edge.get(x).add(new Edge(y, t));
					edge.get(y).add(new Edge(x, t));
				} else {
					edge.get(x).add(new Edge(y, -t));
				}
			}

			boolean flag = false;

			for(int i=1;i<n+1;i++) {
				if(bellmanFord(i)) {
					flag = true;
					break;
				}
			}

			if(flag)
				bw.write("YES\n");
			else
				bw.write("NO\n");		
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	static boolean bellmanFord(int start) {
		Arrays.fill(distance, MAX);
		distance[start] = 0;
		boolean flag = false; // distance 값이 계속 업데이트 되는지 확인용

		for(int k=1;k<n+1;k++) {
			flag = false;
			// n개의 간선에서 모두 flag가 true로 나오는지 확인
			// (계속 순환하여 최소값을 가지게 되는지)
			for(int i=1;i<n+1;i++) {
				for(Edge one : edge.get(i)) {
					int next = one.next;
					int cost = one.cost;

					if(distance[i] != MAX && distance[next]>distance[i]+cost) {
						distance[next] = distance[i]+cost;
						flag = true;
						// 한바퀴를 다 돌고도 계속 순환하여 더 적은 비용을 얻으려는 경우 -> 음수 간선이 있음
					}
				}
			}			
			if(!flag)
				break;			
		}

		// 업데이트가 끊이지 않는 경우
		if(flag) {
			for(int i=1;i<n+1;i++) {
				for(Edge one : edge.get(i)) {
					int next = one.next;
					int cost = one.cost;

					if(distance[i] != MAX && distance[next]>distance[i]+cost) {
						// 다 끝나고 나서 봤는데도 아직도 업데이트(순환) 할 수 있음
						return true;
					}

				}
			}
		}

		return false;
	}
	
	// 94% 시간초과의 원인은 불필요한 에지를 모두 탐색하는 코드였기 때문. 각 노드별 필요한 에지만 탐색할 수 있도록 변경
	static class Edge {
		int next;
		int cost;

		public Edge(int a, int b) {
			next = a;
			cost = b;
		}
	}
}
