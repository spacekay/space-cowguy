import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Hanzo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = 0;
		int count = 0;
		int start = -1;
		
		for(int i=0;i<n;i++) {
			int now = Integer.parseInt(st.nextToken());
			if (now>start) {
				start = now;
        //  조건 연산 회수는 최소한으로
				max = Math.max(max, count);
				count = 0;
			} else {
				count++;
			} 
		}
		br.close();
    // 하지만 예외 조건 체크도 잊지 말자
		max = Math.max(max, count);
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
