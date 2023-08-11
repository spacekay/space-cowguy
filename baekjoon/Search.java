import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 역시 어려운게 맞았음.. 첫 플래티넘 자축!
// 실패함수 table initialize 할 때 최대한 많은 경우의 수를 생각했어야 함.
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
			// i번째 문자의 실패함수를 찾기 위한 인덱스를 구하려면, 
			// 그 전 글자까지 가장 많이 겹치는 시작점이 어디인지를 알아야 한다.
			// while이 아니라 if로만 되어 있으면, index = table[index-1]로 index가 한 차례 변경된 이후에도 
			// P.charAt(index)!=P.charAt(i)인 경우에 다음 탐색이 필요한 정확한 index로 이어서 도달할 수 없다.
			// (그 뒤로 작동하는 table[i]=index가 정확하지 않을 수 있다.)
			// while문이어야 한칸 전으로 돌아가서 다시 index = table[index-1]를 시전할 수 있다. (S와 P를 탐색하는 것과 같은 로직이 되게 해야 한다.)
			// 이전 버전에서 이것을 찾지 못한 것은, 기존 테스트 케이스의 패턴이 길이가 짧거나 패턴이 단순한 편이었기 때문으로 여겨진다.
			// 나중에 다시 봤을 때 이해가 안되면 외우자. 실패 함수 만드는 것과 KMP 실행하는 로직은 근본적으로 같은 것이다.
			while (index>0 && P.charAt(index)!=P.charAt(i)) {
				index = table[index-1];
			}
			if (P.charAt(index)==P.charAt(i)) {
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
