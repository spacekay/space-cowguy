import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=2*(n-1);j++) {
				if(j>n-1-i&&j<n-1+i)
					bw.write("*");
				else if (j<n-1)
					bw.write(" ");
				else
					break;
			}
			bw.write("\n");
		}
		
		for(int i=n-1;i>=1;i--) {
			for(int j=0;j<=2*(n-1);j++) {
				if(j>n-1-i&&j<n-1+i)
					bw.write("*");
				else if (j<n-1)
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
