package numbers0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetCombination {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[n+1];
		combination(visited, 0, n, m);
		System.out.println(sb.toString());
	}
	static void combination(boolean[] visited, int start, int n, int m) {
		if(m==0) { // 필요한 개수만큼 뽑으면 끝
			print(visited, n);
		}
		// 원소 하나를 찍은 상태로 들어가서 그거 빼고 나머지 중에 픽하는 것을 재귀로 계속
		for(int i=start;i<n;i++) {
			visited[i]=true;
			combination(visited,i+1,n,m-1);
			visited[i]=false;
		}
		// 끝나고 나면 이전 수열에서 사용한 숫자들을 다시 사용할 수 있게 해야
		// 다음 combination 함수 실행할 때 이전 수열들에서 사용한 원소들이 쌓이지 않음
	}
	static void print(boolean[] visited, int n) {
		for(int i=0;i<n;i++) {
			if(visited[i]) {
				sb.append(i+1).append(" ");
			}
		}
		sb.append("\n");
	}
}
