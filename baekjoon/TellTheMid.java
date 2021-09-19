import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TellTheMid {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ =new PriorityQueue<>(Comparator.reverseOrder());
    // maxQ의 head 값이 조건에서 의도한 값을 도출하도록 하는 문제
		for(int i=0;i<n;i++) {
			int save=Integer.parseInt(br.readLine());
			if (maxQ.isEmpty()) {
				maxQ.offer(save);
			} else if (maxQ.size()==minQ.size()) {
				if(save>minQ.peek()) {
					maxQ.offer(minQ.poll());
					minQ.offer(save);
				} else {
					maxQ.offer(save);
				}
			} else {
				if (maxQ.peek()>save) {
					minQ.offer(maxQ.poll());
					maxQ.offer(save);	
				} else {
					minQ.offer(save);
				}	
			}
			bw.write(maxQ.peek()+"\n");
		}
		br.close();	
		bw.flush();
		bw.close();
	}
}

