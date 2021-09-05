import java.io.*;
import java.util.*;

public class BalancedWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";
		char c;
		boolean flag;
		Deque<Character> stack;
		while (!(line = br.readLine()).equals(".")) {
			flag = true;
      // Stack을 활용하여 전후 짝 맞추기도 할 수 있다.
      // String class의 method를 사용하는 방식으로는 메모리 점유 및 시간 소요가 커진다.
			stack = new ArrayDeque<>();
			for (int i=0;i<line.length();i++) {
				c = line.charAt(i);
				if (c=='['||c=='(') {
					stack.push(c);
				} else {
					if (c==']') {
						if (stack.isEmpty()||stack.pop()!='[') {
							flag = false;
							break;
						}				
					} else if (c==')') {
						if (stack.isEmpty()||stack.pop()!='(') {
							flag = false;
							break;
						}
					}
				}
			}
			if (!stack.isEmpty())
				flag = false;
			
			if (flag) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}	
		}		
		br.close();
		bw.flush();
		bw.close();
	}
}
