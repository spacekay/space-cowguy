import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Z {
	static int cnt=0;
	static int save;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
    // 재귀는 연습이 필요하다.
		drawZ(n,0,0);
		bw.write(save+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

	public static void drawZ(int n, int x, int y) {
		if(n==1) {
			if(x==c && y==r) {
				save=cnt;
			}	
			cnt++;
			if(x+1==c && y==r) {
				save=cnt;
			}
			cnt++;
			if(x==c && y+1==r) {
				save=cnt;
			}
			cnt++;
			if(x+1==c && y+1==r) {
				save=cnt;
			}
			cnt++;
		} else {
			int m=(int) Math.pow(2, n-1);
      // 범위 조건 설정하는 부분 복습하기
			if(Math.abs(c-x)>=m && Math.abs(r-y)>=m)
				cnt+=m*m;
			else
				drawZ(n-1,x,y);
			if(Math.abs(c-x-m)>=m && Math.abs(r-y)>=m)
				cnt+=m*m;
			else
				drawZ(n-1,x+m,y);
			if(Math.abs(c-x)>=m && Math.abs(r-y-m)>=m)
				cnt+=m*m;
			else
				drawZ(n-1,x,y+m);
			if(Math.abs(c-x-m)>=m && Math.abs(r-y-m)>=m)
				cnt+=m*m;
			else
				drawZ(n-1,x+m,y+m);
		}
	}
}
