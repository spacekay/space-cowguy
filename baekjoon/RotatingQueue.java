import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class RotatingQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Deque<Integer> deq = new ArrayDeque<>();
		for(int i=1;i<n+1;i++)
			deq.offer(i);
		st = new StringTokenizer(br.readLine()," ");
		br.close();
		
		int[] arr = new int[m];
		int sum = 0;
		for(int i=0;i<m;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int size = deq.size();
			int t = 0;
			while(arr[i]!=deq.peek()) {
				deq.addLast(deq.poll());
				t++;
			}
			deq.poll();
			t = Math.min(t, size-t);
			sum += t;
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
