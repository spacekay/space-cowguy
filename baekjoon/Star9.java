import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star9 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();

		for(int i=1;i<=n;i++) {
			for(int j=1;j<2*n+1;j++) {
				if(j>=i && j<=2*n-i)
					bw.write("*");
				else if(i>j)
					bw.write(" ");
				else
					break;
			}
			bw.write("\n");
		}
		
		// 모든 줄에 있는 별의 개수가 홀수임을 확인하여야 함
    // break 필요한 지점도 한 번 더 확인하기
		
		for(int i=n-1;i>=1;i--) {
			for(int j=1;j<2*n+1;j++) {
				if(j>=i && j<=2*n-i)
					bw.write("*");
				else if(i>j)
					bw.write(" ");
				else
					break;
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
