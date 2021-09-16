import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int save=0;
		StringBuilder sb=new StringBuilder();
		Stack<Integer> st = new Stack<>();	
		// 초기값 설정
		int t=1;
		boolean flag=true;
		for(int i=0;i<n;i++) {
			save=Integer.parseInt(br.readLine());
			if (save>=t) {
				// 이미 stack 안에 내가 i번째로 넣었던 것이 처음 나올때까지 push
				// save보다 적은 수는 일단 stack에 넣어봐야 함
				// 오늘의 교훈 : Stack search method는 엄청나게 시간을 먹는다
				// case 수가 커질수록 체감이 커진다
				while(save>=t) {
					// t는 save만큼만 채워줘도 된다. 이후에 push 필요할 때는 그때 넣으면 된다
					st.push(t);
					sb.append("+\n");
					t++;
				}
				// 지금 맨 위에 있는 것을 빼고 다음에 들어온 것을 확인하여 이후 반복문에서 또 체크하면서 push
				// 넣은 수들은 다 밖으로 빼내야 함을 기억함
				st.pop();
				sb.append("-\n");
			} else {
				// 이 상태에서는 더 넣을 필요는 없고 뺄 수 있을 때는 뺀다.
				// 이 때 peek한 값이 save와 다르다면 stack 수열로 구현할 수 없는 것이다.
				// 왜냐하면 push한 순서가 오름차순으로 정해져 있기 때문이다.
				// 빼낼 때의 순서가 그것으로 구현할 수 없다면 실패이다.
				if(st.peek()==save && !st.isEmpty()) {
					st.pop();
					sb.append("-\n");
				} else {
					flag=false;
					break;
				}
			}
		}

		if(flag)
			System.out.println(sb.toString());
		else
			System.out.println("NO");
		br.close();
	}
}
