import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CountingNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[201];
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken()) + 100]++;
		}
		int v = Integer.parseInt(br.readLine());
		bw.write(arr[v + 100] + "\n");
		br.close();
		bw.close();
	}
}
