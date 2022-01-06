import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JoshephusProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");		
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<n+1;i++)
			q.offer(i);
		
		int t = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			// 자료구조를 활용하지 않고도 그냥 원소의 인덱스를 그때그때 일반식으로 구해서 가져올 수도 있음
			if(t%k==0 && q.size()>1) {
				sb.append(q.poll()+", ");
			} else if(t%k==0) {
				sb.append(q.poll());
			} else {
				q.offer(q.poll());
			}
			t++;
		}
		sb.append(">\n");
		System.out.println(sb.toString());
	}
}
