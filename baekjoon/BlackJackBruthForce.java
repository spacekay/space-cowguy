import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 제출 전 추가 출력되는 내용 없는지 확인
public class BlackJackBruthForce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		Integer m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ls = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0 ; i < n ; i++) {		
			ls.add(Integer.parseInt(st.nextToken()));
		}
		Integer[] ans = new Integer[3];
		int sum = 0;
		if (n == 3) {
			for (int i = 0 ; i < 3 ; i++ ) {
				sum += ls.get(i);
			}
		} else {
			int t = n;
			while (t --> 2) {
				ans[0] = ls.get(t);
				for (int i = t-1 ; i > 0 ; i--) {
					ans[1] = ls.get(i);
					for (int j = i-1 ; j >= 0 ; j--) {
						ans[2] = ls.get(j);
						if (ans[0]+ans[1]+ans[2] <= m && ans[0]+ans[1]+ans[2] > sum) {
							sum = ans[0]+ans[1]+ans[2];
						}
					}
				}
			}
		}
		sb.append(sum);
		System.out.println(sb.toString());
		br.close();
	}
}
