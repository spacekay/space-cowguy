import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Paint2x1Tile2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		br.close();
		int[] cnt = new int[n+1];
		cnt[1]=1;
		if(n>1)
			cnt[2]=3;
		for(int i=3;i<=n;i++) {
			// 내가 도출한 점화식 : cnt[i]=cnt[i-1]+2cnt[i-2]
			cnt[i]+=cnt[1]*cnt[i-1];
			// 두칸짜리 안쪽이 일자로만 되어 있는 케이스는 나누기 2해줌 (케이스 중복됨)
			cnt[i]+=(cnt[2]-1)*cnt[i-2];
			cnt[i]%=10007;
		}
		bw.write(cnt[n]+"\n");
		bw.flush();
		bw.close();
	}
}
