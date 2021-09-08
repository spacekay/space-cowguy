import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class SortInside {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String n = br.readLine();
		Character[] arr = new Character[n.length()];
		for(int i=0;i<n.length();i++) {
			arr[i] = n.charAt(i);
		}
		n = "";
		Arrays.sort(arr, Collections.reverseOrder());
		// StringBuilder -> 저장했던 내용 reverse 가능 (너무 긴 문자열이 아니라면 시간 걱정 없이 가능)
		for(char one : arr) {
			n += one;
		}
		bw.write(n+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
