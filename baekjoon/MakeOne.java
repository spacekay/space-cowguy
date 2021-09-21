import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MakeOne {
	static int[] arr;
	static int big=100001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		br.close();
		arr=new int[n+1];
		Arrays.fill(arr, -1);
		bw.write(countMin(n)+"\n");
		bw.flush();
		bw.close();
	}
	public static int countMin(int n) {
		// 아래 save를 하나의 변수 값으로 단순화하면 메모리 점유도 낮아지고 속도도 빨라짐
		// 객체 하나 만드는 거 자체가 오래걸림
		int save0=0;
		int save1=0;
		int save2=0;
		if(n==1) {
			return 0;
		}
		if(arr[n]!=-1) {
			return arr[n];
		}
		if(n%3==0) {
			save0=countMin(n/3)+1;
		} else {
			save0=big;
		}
		if(n%2==0) {
			save1=countMin(n/2)+1;
		} else {
			save1=big;
		}
		save2=countMin(n-1)+1;
		//System.out.println(save0+" "+save1+" "+save2);
		// 아무리 작은 배열이라도 sort보다는 Math.min/max가 더 빠름 (두 수만 비교하는 거니까)
		int result=Math.min(save0, save1);
		// 현재의 수에서 세가지 케이스 돌려 나온 값이 적은 것을 이 자연수의 최솟값으로 저장
		return arr[n]=Math.min(save2, result);
	}
}
