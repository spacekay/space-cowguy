import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ExcitingRunFunction {
  // 재귀와 DP는 든든한 동료관계
	static int[][][] arr = new int[101][101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean flag = true;
		while(flag) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==-1&&b==-1&&c==-1) {
				flag=false;
				break;
			}
			bw.write("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static int w(int a, int b, int c) {
		if(a<=0||b<=0||c<=0)
			return 1;
		else if(arr[a+50][b+50][c+50]==0) {
			if(a>20||b>20||c>20) {
				arr[a+50][b+50][c+50]=w(20,20,20);
			} else if(a<b&&b<c) {
				arr[a+50][b+50][c+50]= w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
			} else {
				arr[a+50][b+50][c+50]= w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
			}
			return arr[a+50][b+50][c+50];
		} else {
			return arr[a+50][b+50][c+50];
		}
	}
}

