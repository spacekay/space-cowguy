import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star8 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();

		for(int i=1;i<=n;i++) {
			for(int j=0;j<2*n;j++) {
				if(j<i || j>2*n-1-i)
					bw.write("*");
				else
					bw.write(" ");
			}
			bw.write("\n");
		}
		
		// 중앙 부분 양쪽 별의 개수가 대칭 (짝수)임을 확인하여야 함
		
		for(int i=n-1;i>=1;i--) {
			for(int j=0;j<2*n;j++) {
				if(j<i || j>2*n-1-i)
					bw.write("*");
				else
					bw.write(" ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
