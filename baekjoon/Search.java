import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 역시 어려운게 맞았음.. 첫 플래티넘 자축!
public class Search {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		String P = br.readLine();
		br.close();
		int L = S.length();
		int l = P.length();
		int[] table = new int[l];
		int index=0;
		for(int i=1;i<l;i++) {
			if(index>0 && P.charAt(index)!=P.charAt(i)) {
				index = table[index-1];
			}
			if(P.charAt(index)==P.charAt(i)) {
				index++;
				table[i]=index;
			}
		}
		StringBuilder sb =new StringBuilder();
		index=0;
		int cnt=0;
		for(int i=0;i<L;i++) {			
			while(index>0&&P.charAt(index)!=S.charAt(i)) {
				index = table[index-1];
			}			
			if(P.charAt(index)==S.charAt(i)) {
				if(index==l-1) {
					// 해당 패턴의 시작 인덱스는 무조건 여기임
					// 끝날때만 해당 패턴의 시작 인덱스를 보여주면 됨 (깔-끔)
					sb.append(i-l+2).append(" ");
					// 바로 다음 문자 대상으로 탐색 가능한지 확인
					index = table[index];
					// table[l-1]은 사실상 접두사의 길이, index는 접두사 직후 문자열이 됨
					// 접두사-접미사가 같다는걸 가정했으므로 같은 패턴이 연이어 나와도 접두사+접미사 길이만큼은 탐색 안해도 됨
					cnt++;
				} else {
					index++;
				}
			}
		}
		bw.write(cnt+"\n");
		//if()
		bw.write(sb.toString()+"\n");
		bw.flush();
		bw.close();
	}
}
