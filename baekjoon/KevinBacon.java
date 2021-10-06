import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class KevinBacon {
	static boolean[][] conn;
	static TreeMap<Integer,Integer> map = new TreeMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		conn = new boolean[n+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			conn[a][b] = conn[b][a] = true;
		}
		br.close();
		for(int i=1;i<=n;i++) {
			BFS(n,i);
		}
		int min = Integer.MAX_VALUE;
		int num=0;
		while(!map.isEmpty()) {
			int key = map.lastKey();
			int value = map.remove(key);
			if(min>=value) {
				min = value;
				num=key;
			}
		}
		bw.write(num+"\n");
		bw.flush();
		bw.close();
	}
	public static void BFS(int n, int v) {
		Queue<Integer> bfs = new LinkedList<Integer>();
		int[] checked = new int[n+1];
		bfs.add(v);
		checked[v]=0;
		int sum=0;
		for (int j = 0 ; j < n ; j++) {
			int m = bfs.poll();
			for (int i = 1 ; i <= n ; i++) {
				if(conn[m][i] && m!=i) {
					// 섬세하게 케이스를 확인할 수 있어야 한다.
					// 딱 사람 숫자만큼만 Queue에서 원소가 드고 날 수 있도록 조정하기
					if(checked[i]==0 && i!=v) {
						bfs.add(i);
						checked[i]=checked[m]+1;
					}
				}
			}			
		}
		for(int i=1;i<=n;i++) {
			if(i!=v)
				sum+=checked[i];
		}
		map.put(v,sum);
	}
}
