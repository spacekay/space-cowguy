import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class PostfixNotation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String eq = br.readLine();
		br.close();
		String backeq = "";
		// 괄호와 연산자를 모두 같은 스택에 넣을 수 있음을 깨닫고 나서 속도가 붙음
		Stack<Character> op = new Stack<>();
		for(int i=0;i<eq.length();i++) {
			if(eq.charAt(i)=='*' || eq.charAt(i)=='/') {
				// 곱셈이나 나눗셈 기호는 2개가 쌓일 수 없는 구조이므로 if만 사용해도 문제 없음
				if(!op.isEmpty() && (op.peek()!='('&&op.peek()!='+'&&op.peek()!='-'))
					backeq += op.pop();
				op.add(eq.charAt(i));
			} else if(eq.charAt(i)=='(') {
				op.add('(');
			} else if(eq.charAt(i)==')') {
				while(op.peek()!='(') {
					backeq += op.pop();
				}
				op.pop();
			} else if(eq.charAt(i)=='+' || eq.charAt(i)=='-') {
				while(!op.isEmpty() && op.peek()!='(')
					backeq += op.pop();
				op.add(eq.charAt(i));
			} else {
				backeq += eq.charAt(i);
			}
		}

		while(!op.isEmpty()) {
			if(op.peek()!='(')
				backeq += op.pop();
			else
				op.pop();
		}
		bw.write(backeq+"\n");
		bw.flush();
		bw.close();
	}
}
