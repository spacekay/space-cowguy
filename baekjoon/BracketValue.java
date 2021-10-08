import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BracketValue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		br.close();
		int l = line.length();
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		int sum=0; // 부분합과 전체합을 둘 다 구현
		for(int i=0;i<l;i++) {
			char c = line.charAt(i);
			if(c=='(') {
				// 괄호의 위치정보를 나타내는 원소와 괄호의 값을 저장하는 원소를 구분하기 위해 음수/양수로 사용 
				stack.push(-2);
			} else if (c=='[') {
				stack.push(-3);
			} else if(c==')') {
				try {
					while(stack.peek()>-1) {
						sum+=stack.pop();
					}
					// if문 개수는 줄일수록 좋음
					if(stack.isEmpty()||stack.peek()==-3) {
						sum=0;
						break;
					}
					if(sum==0) {
						stack.pop();
						stack.push(2);
					} else {
						stack.pop();
						stack.push(sum*2);
						// 여기서 초기화해야 나중에 pop하는 값이 더해진 상태로 남아있지 않음
						sum=0;
					}
				} catch(Exception e) {
					sum=0;
					break;
				}
			} else if(c==']')  {
				if(stack.isEmpty()) {
					sum=0;
					break;
				}
				try {
					while(stack.peek()>-1) {
						sum+=stack.pop();
					}
					if(stack.isEmpty()||stack.peek()==-2) {
						sum=0;
						break;
					}
					if(sum==0) {
						stack.pop();
						stack.add(3);
					} else {
						stack.pop();
						stack.add(sum*3);
						sum=0;
					}
				} catch (Exception e) {
					sum=0;
					break;
				}
			} else {
				flag = false;
				break;
			}
		}
		// 빈틈없는 예외처리를 위한 수많은 sum=0; break;
		sum=0;
		while(!stack.isEmpty() && flag) {
			if(stack.peek()>0)
				sum += stack.pop();
			else {
				sum=0;
				break;
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
