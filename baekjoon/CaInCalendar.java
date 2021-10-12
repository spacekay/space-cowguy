package numbers0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CaInCalendar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;	
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int m=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			bw.write(checkOrder(m,n,x,y)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static int checkOrder(int m, int n, int a, int b) {
		int result = a; // 초반에는 x값과 y값이 동일하게 나타난다.
		boolean flag=false;
		// result가 최소공배수가 넘는 순간부터 이미 모든 경우의 수를 탐색 완료한 것과 같다.
		// 굳이 최소 범위를 만들고 싶다면 최소공배수로 설정해도 된다.
		int lcm=lcm(m,n); // 메소드를 매번 실행하는 데에도 시간이 오래 걸린다. 한 번만 쓰고 저장해두자.
		while(result<=lcm) {
			int y=result%n; // 초기값 기준으로는 n값이 더 작은 경우 반영한다.
			if(y==0) // y가 n의 배수이면 나머지가 0이 되어 버리므로 n으로 만들어 준다.
				y=n;
			if(y==b) { // 이렇게 구한 y값이 실제 달력에 들어가는 숫자와 같다.
				flag=true;
				break;
			}
			result+=m;
			// i번째에서 x값이 a라 하였을 때, i+m번째도 x=a이다. 이를 응용한다.
		}
		if(m==1&&n==1)
			flag=true;
		
		if(flag)
			return result;
		else
			return -1;
	}
	public static int gcd(int a, int b) {
	    while (b != 0) {
	        int r = a % b;
	        a = b;
	        b = r;
	    }
	    return a;
	} 
	public static int lcm(int a, int b) {
	    return a * b / gcd(a, b);
	}
}
