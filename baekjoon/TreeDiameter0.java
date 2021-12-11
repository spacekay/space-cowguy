import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeDiameter0 {

	static ArrayList<Node>[] node;
	static int max;
	static int start = 0;
	static boolean[] checked;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			bw.write(max+"\n");
			bw.flush();
			bw.close();			
			return;
		}

		node = new ArrayList[n+1];
		StringTokenizer st;

		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			node[now] = new ArrayList<>();
			while(st.hasMoreTokens()) {
				int p = Integer.parseInt(st.nextToken());
				if(p==-1)
					break;
				int w = Integer.parseInt(st.nextToken());
				node[now].add(new Node(p, w));			
			}
		}
		br.close();

		// 루트에서 모든 가지의 끝까지 가봄. 가장 가중치 큰 노드를 찾아냄.
		checked = new boolean[n+1];
		checked[1] = true;
		DFS(1, 0);

		Arrays.fill(checked, false);

		// 가장 가중치 큰 노드에서 역시 갈 수 있는 최대한 끝까지 가면 그것이 트리의 지름.
		checked[start] = true;
		DFS(start, 0);

		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}

	public static void DFS(int n, int weight) {

		if(weight > max) {
			max = weight;
			start = n;
		}

		for (Node x : node[n]) {
			if(!checked[x.next]) {
				checked[x.next] = true;
				DFS(x.next, weight+x.weight);
			}
		}
	}		
	
	// 직접 만든 객체 안에 너무 많은 것을 쉽게 넣지 말자.
	static class Node {
		int next;
		int weight;

		public Node (int n, int w) {
			this.next = n;
			this.weight = w;
		}
	}
}
