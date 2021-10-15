import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DrawStars10 {
	static char[][] dots;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		br.close();
		// if문 최소화를 위해 char를 바로 출력하게 하는 것도 좋은듯
		dots = new char[n][n];
		for(int i=0;i<n;i++) {
			// char는 빈 값일 때 공백이 아니므로 초기화해주자.
			// 배열 초기화는 fill method가 좋다.
			Arrays.fill(dots[i], ' ');
		}
		drawStar(n,0,0);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				bw.write(dots[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	public static void drawStar(int n, int x, int y) {
		if(n==3) {
			for(int i=x;i<x+3;i++) {
				for(int j=y;j<y+3;j++) {
					if(i!=x+1||j!=y+1) {
						dots[i][j]='*';
					}
				}
			}
		} else {
			int k=n/3;
			for(int i=x;i<x+n;i+=k) {
				for(int j=y;j<y+n;j+=k) {
					if(i!=x+k||j!=y+k) {
						drawStar(k,i,j);
					}
				}
			}
		}
	}
}
