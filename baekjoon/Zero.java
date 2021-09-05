import java.io.*;
import java.util.Stack;

public class Zero {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
    // Stack 구조를 사용하는 것이 핵심
		Stack<Integer> num = new Stack<>();
		int save = 0;
		for (int i = 0 ; i < k ; i++) {
			save = Integer.parseInt(br.readLine());
			if (save != 0) {
				num.push(save);
			} else {
				num.pop();
			}
		} 
		br.close();

		int sum = 0;
		for (Integer one : num) {
			sum += one;
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
