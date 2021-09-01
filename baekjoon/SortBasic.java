import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortBasic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
    // 가장 기본적인 정렬 방식을 택하였음
		int[] arr = new int[n];	
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int one : arr) {
			sb.append(one+"\n");
		}
		System.out.println(sb.toString());		
	}
}
