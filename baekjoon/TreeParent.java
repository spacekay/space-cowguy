import java.io.*;
import java.util.*;

public class TreeParent {
  // Generic object를 array처럼 사용하는 방법 활용
	static ArrayList<Integer>[] conn;
	static boolean[] printed;
	static int[] parent;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		conn = new ArrayList[n+1];
		printed = new boolean[n+1];
		parent = new int[n+1];
				
		for (int i = 1 ; i < n+1 ; i++) {
			conn[i] = new ArrayList<Integer>();
		}
		
		int a, b;
		for (int i = 0 ; i < n-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			conn[a].add(b);
			conn[b].add(a);

		}
		
		DFS(1);
		
		for (int i = 2 ; i < n+1 ; i++) {
			bw.write(parent[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
  // Stack 사용하기는 어려움
	public static void DFS(int n) {
		printed[n] = true;
		int index = 0;
		for (int i = 0 ; i < conn[n].size() ; i++) {
			index = conn[n].get(i);
			if (!printed[index]) {
				parent[index] = n;
				DFS(index);
			}
		}
	}
}
