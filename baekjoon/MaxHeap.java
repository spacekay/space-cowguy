import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		// 내장 Comparator 메소드 쓰는게 더 빨랐음
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());	
		for(int i=0;i<n;i++) {
			int save=Integer.parseInt(br.readLine());
			if(save==0) {
				// isEmpty도 필요할 때만 작동하도록 내부에 if문 만들어주기
				if(q.isEmpty()) {	
					sb.append("0\n");
				} else if (save==0 && !q.isEmpty()) {
					// remove보다는 poll이 더 메모리도 덜 먹고 빠른듯
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
