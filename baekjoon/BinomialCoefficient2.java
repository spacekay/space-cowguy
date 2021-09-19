import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		br.close();
		// array로 만들어서 heap이 터지진 않을 정도라면 파스칼의 삼각형으로 가능
		int[][] arr = new int[n+1][n+1];
		arr[1][0]=1;
		arr[1][1]=1;
		for(int i=2;i<n+1;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					arr[i][j]=1;
				} else {
					// 이항계수는 곱셈으로만 만드는 값이므로 나머지 연산 후 다시 계수 구해도 동일한 결과
					// (n k)*m = (n*m m*k)  // (n k)%m = (n%m k%m)
					arr[i][j]=(arr[i-1][j-1]+arr[i-1][j])%10007;
				}
			}
		}
		int result=arr[n][k];
			
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}	
}
