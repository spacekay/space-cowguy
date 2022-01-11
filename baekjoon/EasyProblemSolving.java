import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class EasyProblemSolving {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		br.close();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int sum = 0;
		int t = 0;
		outer:
			for(int i=1;i<1000;i++) {
				for(int j=0;j<i;j++) {
					t++;
					if(t>=a && t<=b) {
						sum += i;
					} else if(t>b) {
						break outer;
					}
				}	
			}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
