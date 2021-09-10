import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BackTracking1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		br.close();
		int r = 1;
		for(int i=1;i<=n;i++) {
			r*=i;
		}
		int M=n-m;
		for(int i=1;i<=M;i++) {
			r/=i;
		}	
    // 100% 커스텀 방식으로 손수 만든 알고리즘..!!
    // 이후에는 DFS 방식으로 연구 예정
		String[] result = new String[r];
		String save;
		int random;
		HashSet<Integer> set;
		HashSet<String> all = new HashSet<>();
		int t = 0;
		boolean flag = true;
		while (flag) {
			if (all.size() >= r) {
				flag = false;
				break;
			}
			save="";
			set=new HashSet<>();
			while(save.length()<m) {			
				random = ((int) (Math.random()*n)+1);
				if(set.add(random)) {
					save+=random;
				}
			}
			if(all.add(save)) {
				result[t] = save;
				t++;
			}
		}		
		Arrays.sort(result);
		save="";
		String[] splits;
		for(int i=0;i<r;i++) {
			if(!result[i].equals(save)) {
				save = result[i];
				splits = result[i].split("");
				for(int j=0;j<save.length();j++) {
					bw.write(splits[j]+" ");
				}
				bw.write("\n");		
			}	
		}	
		bw.flush();
		bw.close();
	}
}
