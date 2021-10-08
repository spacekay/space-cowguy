package datastructure0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class N2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int l = line.length();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> num = new Stack<>();
		int sum=0;
		int value = 1;
		boolean flag = false;
		for(int i=0;i<l;i++) {
			char c = line.charAt(i);
			if(c=='(' && flag) {
				stack.add('(');
			} else if(c=='[' && flag) {
				stack.add('[');
				num.add(3);
			} else if(c=='(' && !flag) {
				
			} else if(c=='[' && !flag) {
				
			} else if(c==')') {
				int save = stack.pop();


			} else if(c==']'){


			}			
			System.out.println(c+": "+value+" stack size: "+stack.size());
			if(stack.isEmpty()) {
				while(!num.isEmpty()) {
					sum+=num.pop();
				}
				value=1;
				System.out.println("sum: "+sum);
			}	
		}
		br.close();
		if(!stack.isEmpty()) {
			sum=0;
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}

}
