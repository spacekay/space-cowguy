import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Greedy Algorithm
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] save = new int[n];
		
		for (int i = 0 ; i < n ; i++) {
			save[i] = Integer.parseInt(br.readLine());
		}
		
		boolean run = true;
		int t = 0;
		while (run) {
			for (int i = n-1 ; i >= 0 ; i--) {
				if (k >= save[i]) {
					k -= save[i];
					t++;
					i++;
					continue;
				}
			}	
			if (k == 0) {
				run = false;
				break;
			}
		}
		bw.write(String.valueOf(t));
		bw.flush();
		bw.close();
		br.close();
	}
}
