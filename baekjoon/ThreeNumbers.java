import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeNumbers {

// 머리식히기 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		int[] arr = new int[3];
		int i = 0;
		while(st.hasMoreTokens()) {
			arr[i]=Integer.parseInt(st.nextToken());
			i++;
		}
		Arrays.sort(arr);
		bw.write(arr[1]+"\n");
		bw.flush();
		bw.close();
	}

}
