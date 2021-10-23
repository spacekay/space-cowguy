package recursive0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//  미완성
public class HanoiTower {
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	static Stack<Integer> s3 = new Stack<>();
	static int cnt=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();
		for(int i=n;i>0;i--) {
			s1.add(i);
		}
		//System.out.println(s1.isEmpty());
		moveDisk(1);
		bw.write(cnt+"\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	public static void moveDisk(int i) {
		if(s1.isEmpty()&&s2.isEmpty())
			return;
		if(i==1) {
			if(s1.isEmpty()) {
				moveDisk(2);
			} else if(s3.isEmpty()) {
				System.out.println("1 3 "+s1.peek());
				sb.append("1 3\n");
				s3.push(s1.pop());
				cnt++;
				moveDisk(1);
			} else if(s3.peek()>s1.peek()) {
				System.out.println("1 3 "+s1.peek());
				sb.append("1 3\n");
				s3.push(s1.pop());
				cnt++;
				moveDisk(1);
			} else if(s2.isEmpty()) {
				System.out.println("1 2 "+s1.peek());
				sb.append("1 2\n");
				s2.push(s1.pop());
				cnt++;
				moveDisk(1);
			} else if(s2.peek()>s1.peek()) {
				System.out.println("1 2 "+s1.peek());
				sb.append("1 2\n");
				s2.push(s1.pop());
				cnt++;
				moveDisk(1);
			} else {
				moveDisk(2);
			}
		} else if(i==2) {
			if(s2.isEmpty()) {
				moveDisk(3);
			} else if(s3.isEmpty()) {
				System.out.println("2 3 "+s2.peek());
				sb.append("2 3\n");
				s3.push(s2.pop());
				cnt++;
				moveDisk(1);
			} else if(s3.peek()>s2.peek()) {
				System.out.println("2 3 "+s2.peek());
				sb.append("2 3\n");
				s3.push(s2.pop());
				cnt++;
				moveDisk(1);
			} else if(s1.isEmpty()) {
				System.out.println("2 1 "+s2.peek());
				sb.append("2 1\n");
				s1.push(s2.pop());
				cnt++;
				moveDisk(2);
			} else if(s2.peek()>s1.peek()) {
				System.out.println("2 1 "+s2.peek());
				sb.append("2 1\n");
				s1.push(s2.pop());
				cnt++;
				moveDisk(2);
			} else {
				moveDisk(3);
			}
		} else {
			if(s3.isEmpty()) {
				moveDisk(1);
			} else if(s2.isEmpty()) {
				System.out.println("3 2 "+s3.peek());
				sb.append("3 2\n");
				s2.push(s3.pop());
				cnt++;
				moveDisk(1);
			} else if(s2.peek()>s3.peek()) {
				System.out.println("3 2 "+s3.peek());
				sb.append("3 2\n");
				s2.push(s3.pop());
				cnt++;
				moveDisk(1);
			} else if(s1.isEmpty()) {
				System.out.println("3 1 "+s3.peek());
				sb.append("3 1\n");
				s1.push(s3.pop());
				cnt++;
				moveDisk(1);
			} else if(s1.peek()>s3.peek()) {
				System.out.println("3 1 "+s3.peek());
				sb.append("3 1\n");
				s1.push(s3.pop());
				cnt++;
				moveDisk(1);
			} else {
				moveDisk(1);
			}
		}
	}
}
