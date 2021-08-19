import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class Queue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		// API를 정확히 읽어 예외 발생인지 null return인지 확실히 해야 함
		Queue<Integer> que = new ArrayDeque<Integer>();

		for (int i = 0 ; i < n ; i++) {
			String[] order = br.readLine().split(" ");
			if (order.length > 1) {
				switch (order[0]) {
				case "push":
					que.add(Integer.valueOf(order[1]));
					break;
				default:
					continue;
				}
			} else {
				switch (order[0]) {
				case "pop":
					try {
						sb.append(que.remove());
					} catch (Exception e) {
						sb.append("-1");
					} break;
				case "size":
					sb.append(que.size());
					break;
				case "front":
					try {
						sb.append(que.element());
					} catch (Exception e) {
						sb.append("-1");
					} break;
				case "back":
					if (que.isEmpty()) {
						sb.append("-1");
						break;
					}
					Iterator<Integer> iter = que.iterator();
					int store = 0;
					while (iter.hasNext()) {
						store = iter.next();							
					}
					sb.append(store);
					break;
				case "empty":
					if (que.isEmpty())
						sb.append(1);
					else
						sb.append(0);
					break;
				default:
					continue;
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
