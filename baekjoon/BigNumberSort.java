package sort0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BigNumberSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // StringBuilder 사용 시 메모리(heap)가 부족해지는 경우가 있음
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		for (int i=0 ; i<n; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}	
		int t;
		int k = 0;
		for (int i=0; i<10001; i++) {
			t = 0;
			while (t < count[i]) {
				bw.write(i+"\n");
				t++;
				k++;
			}
			if (k == n)
				break;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
