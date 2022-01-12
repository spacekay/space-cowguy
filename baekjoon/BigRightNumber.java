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
				// While문 돌아갈 때마다 점점 앞쪽 인덱스로 가게 됨
				ans[stack.pop()] = ans[i];
			}
			// 현재 인덱스 값이 스텍에서 뽑은 인덱스 값보다 작으므로 그 위에 쌓임
			// 다음 사이클에서 스택 가장 위에 있는 값 : 직전 값!!!!
			stack.push(i); // 배열의 인덱스
		}
		
		// Good Test Case : 5 \n 5 1 3 2 4
		
		// 끝까지 쌓여있는 인덱스 : 자기 오른쪽에 자기보다 큰 값이 없는 인덱스 (상대적으로 값이 큰 인덱스)
		while(!stack.isEmpty())
			ans[stack.pop()] = -1;
		
		for(int one : ans)
			bw.write(one+" ");
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
