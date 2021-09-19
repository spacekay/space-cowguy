import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
    // 기본값이 오름차순
		PriorityQueue<Integer> q = new PriorityQueue<>();	
		for(int i=0;i<n;i++) {
			int save=Integer.parseInt(br.readLine());
			if(save==0) {
				if(q.isEmpty()) {	
					sb.append("0\n");
				} else if (save==0 && !q.isEmpty()) {
					sb.append(q.poll()).append("\n");	
				}				
			} else {
				q.offer(save);
			}
		}
		br.close();	
		System.out.println(sb.toString());
	}
}
