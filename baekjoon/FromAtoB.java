import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FromAtoB {
  // 데이터의 범위가 매우 넓었다. 세세하게 자료형 챙겨주자.
	static long result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		BFS(a,b);
		if(result==Integer.MAX_VALUE) {
			bw.write("-1\n");
		} else {
			bw.write(result+"\n");
		}	
		bw.flush();
		bw.close();
	}
	public static void BFS(long a, long b) {
		Queue<Carrier> q = new LinkedList<>();
		q.offer(new Carrier(a,1));
		while(!q.isEmpty()) {
			Carrier now = q.poll();
			long n = now.n;
			long cnt = now.cnt;
			if(n==b) {
				if(result>cnt)
					result=cnt;
			} else if(n>b) {
			} else {
				q.offer(new Carrier(n*2,cnt+1));
				q.offer(new Carrier(n*10+1,cnt+1));
			}
		}
	}
	static class Carrier{
		long n;
		long cnt;
		public Carrier(long x, long y) {
			n=x;
			cnt=y;
		}
	}
}
