import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeColoredPaper {
	static int cntBlue=0;
	static int cntWhite=0;
	static int n;
	static boolean[][] conn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		conn = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				// charAt + if문 쓰는 시간이 영향 줄 수도 있을듯
				if(line[j].charAt(0)=='1') {
					conn[i][j]=true;
				} 
			}
		}
		br.close();
		checkArea(0,0,0);
		bw.write(cntWhite+"\n");
		bw.write(cntBlue+"\n");
		bw.flush();
		bw.close();
	}
	public static void checkArea(int x, int y, int level) {
		int pow2 = (int) Math.pow(2,level);
		int k= n/pow2;
		boolean flagWhite = false;
		boolean flagBlue = false;
		if(conn[x][y]) {
			flagBlue=true;
			outer:
			for(int i=x;i<x+k;i++) {
				for(int j=y;j<y+k;j++) {
					if(!conn[i][j]) {
						flagBlue=false;
						break outer;
					}
				}
			}
		} else {
			flagWhite=true;
			outer:
			for(int i=x;i<x+k;i++) {
				for(int j=y;j<y+k;j++) {
					if(conn[i][j]) {
						flagWhite=false;
						break outer;
					}
				}
			}
		}
		if(flagBlue) {
			cntBlue++;
		} else if (flagWhite) {
			cntWhite++;
		} else {
			// 아래 네 개가 서로 같은 색인지 확인하는 절차 사용할 수도 있음
			checkArea(x,y,level+1);
			checkArea(x+k/2,y,level+1);
			checkArea(x,y+k/2,level+1);
			checkArea(x+k/2,y+k/2,level+1);
		}
	}
}
