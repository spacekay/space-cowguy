package graph0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		printed[v] = true;
		boolean[] newprinted = printed.clone();
		sb.append(v+" ");
		DFS(check, printed, n, v);
		sb.append("\n"+v+" ");
		BFS(newcheck, newprinted, n, v);
		System.out.println(sb.toString());
		br.close();
	}
	public static int DFS(boolean[][] check, boolean[] printed, int n, int v) {
		if (v == 0)
			return 0;		
		int forreturn = 0;
		for (int i = 1 ; i <= n ; i++) {
			if (check[v][i] && !printed[i]) {
				check[v][i] = false;
				printed[i] = true;
				sb.append(i+" ");
				//System.out.println(i);
				return DFS(check, printed, n, i);
			} else if (check[i][v] && !printed[i]){
				check[i][v] = false;
				printed[i] = true;
				sb.append(i+" ");
				//
				return DFS(check, printed, n, i);
			} else if (check[i][v] || check[v][i]) {
				forreturn = i;
			} 
		}
		if (forreturn > v) {
			for (int i = 1 ; i <= n ; i++) {
				if (!printed[i]) {
					forreturn = i;
					break;
				} else if (i == n) {
					return 0;
				}
			}
		}		
		return DFS(check, printed, n, forreturn);
	}
	public static int BFS(boolean[][] newcheck, boolean[] newprinted, int n, int v) {
		if (v == 0)
			return 0;	
		int forreturn = n+1;
		for (int i = 1 ; i <= n ; i++) {
			if (newcheck[v][i] && !newprinted[i]) {
				newcheck[v][i] = false;
				newprinted[i] = true;
				sb.append(i+" ");
				System.out.println(i);
				if (i < forreturn) {
					forreturn = i;
				}
			} else if (newcheck[i][v] && !newprinted[i]){
				newcheck[i][v] = false;
				newprinted[i] = true;
				sb.append(i+" ");
				System.out.println(i);
				if (i < forreturn) {
					forreturn = i;
				}
			}
		}
		System.out.println("return "+forreturn);
		if (forreturn > v) {
		
		/* 6 5 6
			5 4
			4 6
			2 3
			3 1
			1 6
			이 반례 해결하려면 위로 다시 올라가서 4가 있는 곳까지 간 다음
			5로 다시 내려올 수 있어야 한다.  --> 정신 멀쩡할 때 그냥 Queue로 풀이 예정*/
			
			return 0;
		}		
		return BFS(newcheck, newprinted, n, forreturn);
	}
}
