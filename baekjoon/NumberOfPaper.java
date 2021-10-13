import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberOfPaper {
	static int cntPlus=0;
	static int cntZero=0;
	static int cntMinus=0;
	static int n;
	static int[][] conn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		conn = new int[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				conn[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		checkArea(0,0,0,1);
		bw.write(cntMinus+"\n");
		bw.write(cntZero+"\n");
		bw.write(cntPlus+"\n");
		bw.flush();
		bw.close();
	}
	public static void checkArea(int x, int y, int level, int pow) {
		// Math.pow도 시간이 걸린다.
		int k= n/pow;	
		int init = conn[x][y];
		int flag = init;
		outer:
			for(int i=x;i<x+k;i++) {
				for(int j=y;j<y+k;j++) {
					if(conn[i][j]!=init) {
						flag=-2;
						break outer;
					}
				}
			}
		if(flag==1) {
			cntPlus++;
		} else if (flag==0) {
			cntZero++;
		} else if(flag==-1) {
			cntMinus++;
		} else {
			// 아래 9개가 서로 같은 색인지 확인하는 절차 사용할 수도 있음
			// 반복 연산은 최소화
			int pow3=pow*3;
			checkArea(x,y,level+1,pow3);
			checkArea(x+k/3,y,level+1,pow3);
			checkArea(x+k*2/3,y,level+1,pow3);
			checkArea(x,y+k/3,level+1,pow3);
			checkArea(x,y+k*2/3,level+1,pow3);
			checkArea(x+k/3,y+k/3,level+1,pow3);
			checkArea(x+k/3,y+k*2/3,level+1,pow3);
			checkArea(x+k*2/3,y+k/3,level+1,pow3);
			checkArea(x+k*2/3,y+k*2/3,level+1,pow3);	
		}
	}
}
