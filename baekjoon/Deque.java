package datastructure0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Deque {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		// ArrayDeque vs. LinkedList는 ArrayDeque의 승리
		Deque<Integer> deq = new ArrayDeque<Integer>();

		for (int i = 0 ; i < n ; i++) {
			String[] order = br.readLine().split(" ");
			if (order.length > 1) {
				switch (order[0]) {
				case "push_front":
					deq.addFirst(Integer.valueOf(order[1]));
					break;
				case "push_back":
					deq.addLast(Integer.valueOf(order[1]));
					break;
				default:
					continue;
				}
			} else {
				switch (order[0]) {
				case "pop_front":
					try {
						sb.append(deq.removeFirst());
					} catch (Exception e) {
						sb.append("-1");
					} break;
				case "pop_back":
					try {
						sb.append(deq.removeLast());
					} catch (Exception e) {
						sb.append("-1");
					} break;
				case "size":
					sb.append(deq.size());
					break;
				case "front":
					try {
						sb.append(deq.getFirst());
					} catch (Exception e) {
						sb.append("-1");
					} break;
				case "back":
					try {
						sb.append(deq.getLast());
					} catch (Exception e) {
						sb.append("-1");
					} break;
				case "empty":
					if (deq.isEmpty())
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
