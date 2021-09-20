import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WhoIsIt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> notHear = new LinkedHashSet<>();
		for(int i=0; i<n;i++) {
			notHear.add(br.readLine());
		}
		PriorityQueue<String> q=new PriorityQueue<>();
		for(int i=0; i<m;i++) {
			String notSee = br.readLine();
			if(notHear.contains(notSee)) {
				q.offer(notSee);
			}
		}
		br.close();
		bw.write(q.size()+"\n");
		while(!q.isEmpty()) {
			bw.write(q.poll()+"\n");
		}
		bw.flush();
		bw.close();
	}
}
