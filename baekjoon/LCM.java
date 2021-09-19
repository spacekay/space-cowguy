import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LCM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			bw.write(getLCM(a,b)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int getLCM(int a, int b) {
		int gcd=getGCD(a,b);
    // 최대공약수는 한 번만 나누어주기
		int lcm=a*b/gcd;
		return lcm;
	}
	
	public static int getGCD(int a, int b) {
		int gcd=0;
		int save1=a;
		int save2=b;
		while (true) {
			save1%=save2;
			if(save1==0) {
				gcd=save2;
				break;
			} else {
        // 각 변수가 매 스텝에서 어떤 연산을 받을지 생각하기
				save2%=save1;
				if(save2==0) {
					gcd=save1;
					break;
				}
			}
		}
		return gcd;
	}
}
