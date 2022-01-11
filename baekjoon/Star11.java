import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star11 {
	static boolean[][] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		br.close();
		
		arr = new boolean[n][n*2];
		
		drawStar(n, 0, 0);
		
		for(int i=0;i<n;i++) {
			for (int j=1;j<n*2;j++) {
				if(arr[i][j])
					bw.write("*");
				else
					bw.write(" ");
			}
			bw.write("\n");
		}	
		bw.flush();
		bw.close();
	}
	
	static void drawStar(int k, int x, int y) {
		if(k==3) {
			arr[y][x+3] = true;
			arr[y+1][x+2] = true;
			arr[y+1][x+4] = true;
			for(int i=1;i<6;i++)
				arr[y+2][x+i] = true;
		} else {
			// x좌표와 y좌표의 스케일이 2배 차이남을 확인하면 풀이할 수 있다.
			drawStar(k/2, x+k/2, y);
			drawStar(k/2, x, y+k/2);
			drawStar(k/2, x+k, y+k/2);
		}
		
	}
}
