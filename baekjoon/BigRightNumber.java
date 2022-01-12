import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BigRightNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		
		int[] ans = new int[n];
		
		for(int i=0;i<n;i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();

		for(int i=0;i<n;i++) {
			// 스택에서 뽑은 인덱스 값이 현재 인덱스 값보다 작으면 현재 값으로 대체
			// (스택에서 뽑은 인덱스 값에서 가장 가까운 값이므로)
			while(!stack.isEmpty() && ans[stack.peek()]<ans[i]) {
				ans[stack.pop()] = ans[i];
			}
			stack.push(i); // 배열의 인덱스
		}
		
		while(!stack.isEmpty())
			ans[stack.pop()] = -1;
		
		for(int one : ans)
			bw.write(one+" ");
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
