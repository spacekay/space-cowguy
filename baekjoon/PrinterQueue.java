import java.io.*;
import java.util.*;

public class PrinterQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		int n, m, l;
		StringTokenizer st;
		Queue<Integer> q;
		int t;
		for (int i=0; i<x ;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			t = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j < n ; j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			l = q.size();
			Integer[] arr = new Integer[l];
			q.toArray(arr);			
			Arrays.sort(arr, Collections.reverseOrder());
			for (int j=0;j<l;j++) {
				if (arr[j]>q.peek()) {
					q.offer(q.remove());				
					if (m > 0) {
						m -= 1;
					} else {
						m += q.size()-1;
					}
					j--;
				} else if (arr[j]==q.peek()) {
					q.remove();
					if (m > 0) {
						m -= 1;
						t++;
					} else {
            // 어떤 상황에서건 동일한 초기화가 일어나도록 하는 것이 중요하다.
						m += q.size()-1;
						t++;
						break;
					}
				}			
			}
			bw.write(t+"\n");
		}
		br.close();	
		bw.flush();
		bw.close();
	}
}
