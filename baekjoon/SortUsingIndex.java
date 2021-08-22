import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] age = new int[n][2];
		String[] name = new String[n];
		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			age[i][0] = Integer.parseInt(st.nextToken());
			age[i][1] = i;
			name[i] = st.nextToken();
		}
    
    // 문제의 입력, 출력 조건을 한 번 더 살피고 제출하자.
		Arrays.sort(age, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < n ; i++) {
			sb.append(age[i][0]+" ");
			sb.append(name[age[i][1]]+"\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
