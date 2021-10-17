package blog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9019 {
	static int result;
	static String[] results=new String[10000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			BFS(a,b);
			bw.write(results[result]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static void BFS(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		visited[a]=true;
		q.offer(a);
		results[a]="";
		while(!q.isEmpty()) {
			int n=q.poll();
			int didD=getD(n);
			if(!visited[didD]) { 
				// 일종의 DP 응용
				visited[didD]=true;
				results[didD]=results[n]+"D";
				if(didD==b) {
					result=didD;
					return;
				}
				q.offer(didD);
			}
			int didS=getS(n);
			if(!visited[didS]) { 
				visited[didS]=true;
				results[didS]=results[n]+"S";
				if(didS==b) {
					result=didS;
					return;
				}
				q.offer(didS);
			}
			int didL=getL(n);
			if(!visited[didL]) { 
				visited[didL]=true;
				results[didL]=results[n]+"L";
				if(didL==b) {
					result=didL;
					return;
				}
				q.offer(didL);
			}
			int didR=getR(n);
			if(!visited[didR]) { 
				visited[didR]=true;
				results[didR]=results[n]+"R";
				if(didR==b) {
					result=didR;
					return;
				}
				q.offer(didR);
			}
		}
	}
	public static int getD(int n) {
		n*=2;
		if(n>=10000) {
			n%=10000;
		}
		return n;	
	}
	public static int getS(int n) {
		if(n==0)
			n=9999;
		else
			n-=1;
		return n;
	}
	// getL과 getR을 정석대로 진행하는 것도 좋지만..
	// 최대한 단순화할수 있다면 더 빠를 것이다.
	public static int getL(int n) {
		int x = (n*10)%10000; // 1000의 배수는 x=0되어버림
		int y = n/1000;
		return x+y;
	}
	public static int getR(int n) {
		int x = n/10;
		int y = (n%10)*1000;
		return x+y;
	}
}
