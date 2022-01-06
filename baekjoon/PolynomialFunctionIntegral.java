import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class PolynomialFunctionIntegral {
  
	// 수많은 분기들을 정확하게 구현해내는 것 자체가 문제의 의도
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String equation = br.readLine();
		br.close();
		String now = "";
		String opr = "";
		Queue<Integer> q = new LinkedList<>();
		boolean flag = false;
    
		for(int i=0;i<equation.length();i++) {			
			char c = equation.charAt(i);
			if(c>='0' && c<='9' || c=='-') {
				now += c;
			} else if(c=='x') {
				q.offer(Integer.parseInt(now));
				now = "";
				flag = true;
			} else {
				opr = Character.toString(c);
			}
		}
		
		int save = -10001;
		if(!now.equals("")) {
			q.offer((save=Integer.parseInt(now)));
		}
		String neweq = "";
		if(flag) {
			if(q.peek()>2 || q.peek()<-2)
				neweq += q.poll()/2;
			else if(q.peek()==-2) {
				neweq += "-";
				q.poll();
			} else
				q.poll();
			neweq += "xx";
			neweq += opr;
		}
		if(save != -10001 && q.peek()!=0) {
			if(q.peek()>1 || q.peek()<-1)
				neweq += q.poll();
			else if(q.peek()==-1) {
				neweq += "-";
				q.poll();
			} else
				q.poll();
			neweq += "x+";
		}

		if(!neweq.endsWith("+") && !neweq.endsWith("-") && opr.equals("") && save != 0)
			neweq += "+";
		neweq += "W\n";

		bw.write(neweq);		
		bw.flush();
		bw.close();
	}
}

