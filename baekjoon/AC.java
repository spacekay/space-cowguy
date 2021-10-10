import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		outer:
			for(int i=0;i<T;i++) {
				String p = br.readLine();
				int n=Integer.parseInt(br.readLine());
				// StringBuilder를 활용하여 좀더 빠르게 String을 다룰 수 있다
				StringBuilder arr = new StringBuilder(br.readLine());
				arr.deleteCharAt(0);
				arr.deleteCharAt(arr.length()-1);
				st = new StringTokenizer(arr.toString(),",");
				// 양 방향 왔다갔다 하면서 처음-끝 원소 접근하는 것은 Deque가 끝판왕
				// ArrayDeque 클래스가 빠르다.
				Deque<Integer> deq = new ArrayDeque<>();
				boolean flag = true;
				for(int j=0;j<n;j++) {
					deq.offer(Integer.parseInt(st.nextToken()));
				}
				int k = p.length();
				for(int j=0;j<k;j++) {
					try {
						if(p.charAt(j)=='R') {
							flag = !flag;
						} else if(flag) {
							deq.removeFirst();
						} else {
							deq.removeLast();
						}
					} catch(Exception e) {
						bw.write("error\n");
						continue outer;
					}
				}
				StringBuilder sb = new StringBuilder();
				int l=deq.size();
				if(l==0) {
					sb.append("[");
				} else if(flag) {
					sb.append("[").append(deq.poll());
					for(int j=1;j<l;j++) {
						sb.append(",").append(deq.poll());
					}
				} else {
					sb.append("[").append(deq.pollLast());
					for(int j=1;j<l;j++) {
						sb.append(",").append(deq.pollLast());
					}
				}
				sb.append("]\n");
				bw.write(sb.toString());
			}
		br.close();
		bw.flush();
		bw.close();
	}
}
