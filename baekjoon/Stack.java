import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		// API를 정확히 읽어 예외 발생인지 null return인지 확실히 해야 함
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0 ; i < n ; i++) {
			String[] order = br.readLine().split(" ");
			switch (order[0]) {
			case "push":
				stk.push(Integer.valueOf(order[1]));
				break;
			case "pop":
				try {
					sb.append(stk.pop()+"\n");
				} catch (Exception e) {
					sb.append("-1\n");
				} break;
			case "size":
				sb.append(stk.size()+"\n");
				break;
			case "top":
				try {
					sb.append(stk.peek()+"\n");
				} catch (Exception e) {
					sb.append("-1\n");
				} break;
			case "empty":
				if (stk.isEmpty())
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
				break;
			default:
				continue;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
