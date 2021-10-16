import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuadTree {
	static int[][] vid;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		vid=new int[n][n];
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<n;j++) {
				vid[i][j]=line.charAt(j)-'0';
			}
		}
		br.close();
		quadTree(n,0,0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	public static void quadTree(int n, int x, int y) {		
		if(n==1) {
			sb.append(vid[x][y]);		
		} else {				
			boolean flag=false;
			for(int i=x;i<x+n;i++) {
				for(int j=y;j<y+n;j++) {
					if(vid[i][j]!=vid[x][y]) {
						flag=true;
						break;
					}
				}
			}
			if(flag) {
				// 재귀 추가 실행해야 할 때만 괄호를 그리는 것이 포인트
				sb.append("(");
				for(int i=x;i<x+n;i+=n/2) {
					for(int j=y;j<y+n;j+=n/2) {				
						quadTree(n/2,i,j);						
					}
				}
				sb.append(")");
			} else {
				sb.append(vid[x][y]);
			}
		}
	}
}
