import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixPlus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];

		for (int i = 0; i < n * 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if (i < n)
					arr[i][j] = Integer.parseInt(st.nextToken());
				else
					arr[i - n][j] += Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
