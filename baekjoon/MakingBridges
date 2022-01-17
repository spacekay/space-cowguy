import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 결국 이항계수 구하는 문제
public class MakingBridges {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int l=0;l<T;l++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			int tmp = n;
			if(n<k) {
				n = k;
				k = tmp;
			}				
			
			int[][] arr = new int[n+1][n+1];
			arr[1][0]=1;
			arr[1][1]=1;
			for(int i=2;i<n+1;i++) {
				for(int j=0;j<=i;j++) {
					if(j==0) {
						arr[i][j]=1;
					} else {
						arr[i][j]=(arr[i-1][j-1]+arr[i-1][j]);
					}
				}
			}	
			int result=arr[n][k];		
			bw.write(result+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

