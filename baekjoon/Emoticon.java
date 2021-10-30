import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// DP + BFS
public class Emoticon {
	static int min = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();
		if(n==1)
			min=0;
		else
			BFS(n);	
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
	public static void BFS(int n) {
		boolean[][] visit = new boolean[n+4][n+4];
		Queue<ClipBoard> q = new LinkedList<>();
		// 큐에 들어가는 순간 다 방문처리 해주어야 이미 큐 안에 든 원소들로 재탐색하지 않음
		// BFS에서는 너무 가짓수가 늘어나면 시간 소요가 엄청나게 늘어남
		q.offer(new ClipBoard(1, 1, 1));
		visit[1][1]=true;
		while(!q.isEmpty()) {
			ClipBoard now = q.poll();
			int in = now.in;
			int out = now.out;
			int t = now.t;
			if(out==n) {
				if(min>t)
					min=t;
				return;
			} else if(t>=min) {
				return;
			}
      //  visit array 범위 넘지 않도록.
			if(out>0&&out<n+3) {
				// 화면의 임티 하나 지우기
				if(!visit[in][out-1]) {
					q.offer(new ClipBoard(in,out-1,t+1));
					visit[in][out-1] = true;
				}
					
				// 클립보드에 저장하기
				if(!visit[out][out]) {
					q.offer(new ClipBoard(out,out,t+1));
					visit[out][out] = true;
				}
					
			}
			if(in>0&&in+out<n+3) {
				// 화면에 붙여넣기
				if(!visit[in][out+in]) {
					q.offer(new ClipBoard(in,out+in,t+1));
					visit[in][out+in] = true;
				}
					
			}

		}
	}
	static class ClipBoard{
		int in;
		int out;
		int t;
		public ClipBoard(int a, int b, int c) {
			in=a;
			out=b;
			t=c;
		}
	}
}
