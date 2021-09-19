import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class FashionKing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashMap<String, Integer> map;
		for(int i=0;i<n;i++) {
			map= new HashMap<>();
			int k=Integer.parseInt(br.readLine());
			for(int j=0;j<k;j++) {
				st=new StringTokenizer(br.readLine()," ");
				st.nextToken();
				String kind=st.nextToken();
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				} else {
					map.put(kind, 1);
				}	
			}
			int mtp=1;
			int save;
			Iterator<String> iter=map.keySet().iterator();
			while(iter.hasNext()) {
				save=map.get(iter.next());
				// 내 힘으로 알고리즘 직접 찾아보는 것도 보람있는 일이다.
				mtp*=(save+1);
			}
			mtp--;
			bw.write(mtp+"\n");
		}		
		br.close();
		bw.flush();
		bw.close();
	}
}
