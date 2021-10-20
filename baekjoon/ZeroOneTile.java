import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ZeroOneTile {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		br.close();
		int[] arr = new int[n+1];
		arr[1]=1;
		// n=1인 경우도 확인해야 함 // arr[0]=1로 가정하여 풀어도 풀림
		if(n>1)
			arr[2]=2;
		for(int i=3;i<=n;i++) {
			// 뒤에 00을 붙이면 2자리 증가
			// 뒤에 1을 붙이면 1자리 증가
			arr[i]=(arr[i-1]+arr[i-2])%15746;
		}
		bw.write(arr[n]+"\n");
		bw.flush();
		bw.close();
	}
}
