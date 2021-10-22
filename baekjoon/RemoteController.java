import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RemoteController {
	static int n;
	static int m;
	static boolean[] button=new boolean[10]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		// m=0인 경우 추가 입력을 아예 받으면 안됨
		if(m!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<m;i++) {
				button[Integer.parseInt(st.nextToken())]=true;
			}
		}
		br.close();
		int min_cnt = Math.abs(100-n);
    // 
		for(int i=0;i<=1000000;i++) {
			// 이 숫자가 번호판으로 다 누를 수 있는지 판정
			// 눌러서 아예 표현할 수 없는 숫자면 고려대상이 아님
			int cnt = check(i);
			if(cnt>0) {
				int plMi = Math.abs(n-i);
				min_cnt = Math.min(min_cnt, plMi+cnt);
			}
		}
		bw.write(min_cnt+"\n");
		bw.flush();
		bw.close();
	}
	public static int check(int a) {
		if(a==0) {
			if(button[0])
				return 0;
			else
				return 1;
		}
		int cnt = 0;
		// 한 자리씩 뒤에서부터 탐색하기
		// 다 끝나고 나면 a는 해당 값의 몫이므로 0이 된다.
		while(a>0) {
			// 한 숫자라도 숫자 버튼으로 누를 수 없는 경우 그냥 다른 숫자를 입력하는게 나음
			// 바로 break 해버릴 수 있음
			if(button[a%10]) {
				return 0;
			}
			a/=10;
			cnt+=1;
		}
		return cnt;
	}
}
