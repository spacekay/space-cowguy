import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFSBFS {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		boolean[][] check = new boolean[n+1][n+1]; 
		int[] save = new int[2];
		for (int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			save[0] = Integer.parseInt(st.nextToken());
			save[1] = Integer.parseInt(st.nextToken());
			if (!check[save[0]][save[1]]) {
				check[save[0]][save[1]] = true;
				check[save[1]][save[0]] = true;
			}
		}
		boolean[][] newcheck = check.clone();
		boolean[] printed = new boolean[n+1];
		boolean[] newprinted = printed.clone();
		DFS(check, printed, n, v);
		sb.append("\n");
		BFS(newcheck, newprinted, n, v);
		System.out.println(sb.toString());
		br.close();
	}
	public static void DFS(boolean[][] check, boolean[] printed, int n, int v) {
		Stack<Integer> dfs = new Stack<Integer>();
		boolean flag = false;
		// 위에 하나 쌓기
		dfs.push(v);
		sb.append(v+" ");
		printed[v] = true;		
		while (!dfs.isEmpty()) {
			// 이전 루프에서 뒤쪽에 연결되어 있던 노드를 앞쪽으로 당겨와서 그 뒤에 달린 것이 더 있는지 확인한다.
			// 이전 루프에서 하나 빼 버린 경우 가장 최근에 갔던 노드로 다시 돌아가게 된다.
			v = dfs.peek();
			flag = false;
			for (int i = 1 ; i <= n ; i++) {
				if(check[v][i] && !printed[i]) {
					// 아이템을 추가할 때 항상 맨 위에 쌓이는 부분이 핵심으로 보인다.
					dfs.push(i);
					sb.append(i+" ");
					printed[i] = true;
					flag=true;
					// DFS는 한 군데에서 계속 앞으로 나아가야 함, 그러므로 옆에 있는 곳은 나중에 감
					break;
				} else if (check[i][v] && !printed[i]) {
					dfs.push(i);
					sb.append(i+" ");
					printed[i] = true;
					flag=true;
					break;
				}
			}	
			// 뒤에 달린 것이 더 없는 경우엔 빼버린다.
			if (!flag) {
				dfs.pop();
			}		
		}	
	}
	public static void BFS(boolean[][] newcheck, boolean[] newprinted, int n, int v) {
		Queue<Integer> bfs = new LinkedList<Integer>();
		bfs.add(v);
		newprinted[v] = true;		
		while (!bfs.isEmpty()) {
			// 그 다음 연결된 노드들 중에 가장 빠른 숫자가 먼저 튀어나온다.
			// 그 다음은 이전에 튀어나온 숫자 다음으로 저장된 숫자가 나온다.
			// 따라서 특정 레벨의 숫자들이 다 끝나고 나야 다음 레벨 숫자들을 검증한다.
			v = bfs.poll();
			sb.append(v+" ");			
			// v와 연결된 것들은 다 뽑아내야 for문이 끝난다.
			for (int i = 1 ; i <= n ; i++) {
				if(newcheck[v][i] && !newprinted[i]) {
					bfs.add(i);
					newprinted[i] = true;
				} else if (newcheck[i][v] && !newprinted[i]) {
					bfs.add(i);
					newprinted[i] = true;
				}
			}			
		}	
	}
}
