import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class SanggeunNald {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] menu = new int[5];
		for(int i=0;i<5;i++) {
			menu[i]=Integer.parseInt(br.readLine());
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				q.offer(menu[i]+menu[j+3]-50);
			}
		}
		bw.write(q.peek()+"\n");
		bw.flush();
		bw.close();
	}
}
