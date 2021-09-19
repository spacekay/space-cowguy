import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class AbsHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)-> {
				Integer n1=Math.abs(o1);
				Integer n2=Math.abs(o2);
				// Integer는 equals를 썼어야지! 간만에 remind함
				if(n1.equals(n2)) {
					return Integer.compare(o1, o2);
				} else {
					return Integer.compare(n1, n2);
				}			
		});
		for(int i=0;i<n;i++) {
			int save=Integer.parseInt(br.readLine());
			if(save==0) {
				if(q.isEmpty()) {	
					bw.write("0\n");
				} else {
					bw.write(q.poll()+"\n");	
				}				
			} else {
				q.offer(save);
			}
		}
		br.close();	
		bw.flush();
		bw.close();
	}
}
