import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String save;
		Deque<Integer> q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			save=br.readLine();
			switch(save.charAt(1)) {
			case 'u':
				st=new StringTokenizer(save," ");
				st.nextToken();
				q.offer(Integer.parseInt(st.nextToken()));
				break;
			case 'm':
				if(q.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case 'i':
				sb.append(q.size()+"\n");
				break;
			case 'o':
				try {
					sb.append(q.pop()+"\n");
				} catch (Exception e) {
					sb.append("-1\n");
				}
				break;
			case 'r':
				try {
					sb.append(q.element()+"\n");
				} catch (Exception e) {
					sb.append("-1\n");
				}
				break;
			case 'a':
				try {
					sb.append(q.getLast()+"\n");
				} catch (Exception e) {
					sb.append("-1\n");
				}
				break;		
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
