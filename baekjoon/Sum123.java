import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sum123 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[12];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for(int j=0;j<T;j++) {
			int n=Integer.parseInt(br.readLine());
			for(int i=4;i<=n;i++) {
				if(arr[i]==0) {
					// 1, 2, 3만 사용하므로 세 개 수에 대해서만 관리하면 됨
					// 끝에 1을 붙이는 케이스 : arr[i-1]
					// 끝에 2를 붙이는 케이스 : arr[i-2]
					// 끝에 3을 붙이는 케이스 : arr[i-3]
					arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
				}		
			}
			bw.write(arr[n]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
