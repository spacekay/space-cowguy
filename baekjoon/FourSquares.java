import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class FourSquares {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		int[] cnt = new int[N+1];
		cnt[1]=1;
		for(int i=2;i<N+1;i++) {
			int min=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				min = Math.min(min, cnt[i-j*j]);
			}
			// 빼는 횟수가 늘어날수록 cnt가 증가하는 효과
			cnt[i]=min+1;
		}
		bw.write(cnt[N]+"\n");
		bw.flush();
		bw.close();
	}
}

// 60퍼 쯤에서 자꾸 에러가 난다.
//이 방식으론 뭔가 꼬이게 되는 케이스가 있긴 한듯. DP가 안전하다
/*public class N17626Greedy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		br.close();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int n = (int) Math.sqrt(N);
		for(int i=n;i>0;i--) {
			long sum=0;
			int cnt=0;
			for(int j=i;j>0;j--) {
				if(cnt==4)
					break;
				sum+=j*j;
				if(sum>N) {
					sum-=j*j;
					continue;
				} else if(sum==N) {			
					cnt++;
					q.offer(cnt);
				//	System.out.println(sum+" "+cnt+"*"+i);
					break;
				} else {
					cnt++;
					j++;
					//System.out.println(sum+" "+cnt);
				}
			}		
		}
		bw.write(q.poll()+"\n");
		bw.flush();
		bw.close();
	}
}*/
