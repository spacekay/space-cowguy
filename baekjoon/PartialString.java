import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// KMP algorithm 학습 계기 (매우중요!)
public class PartialString {
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
			// index는 접두사의 길이
			// 이전 for문에서 아래 if문과 비교한 문자와 index는 다르기 때문에
			// 전혀 염려할 필요가 없다.
			if(index>0 && P.charAt(i)!=P.charAt(index)) {
				// 접두사와 접미사가 i의 지점에서는 index 길이만큼은 될 수 없다.
				// index-1 지점의 table에 저장된 값이 아래 if문을 통해 진행한 것의 반대 작업
				System.out.println("*"+index);
				index = table[index-1];
			}
			// i의 위치 : 접미사 시작, index=0 : 접두사 시작
			if(P.charAt(i)==P.charAt(index)) {
				index++;
				// 실제 table 값에는 1로 들어감
				// 위쪽 if문에서는 0부터 index 기준에 맞게 들어감
				table[i]=index;
			}
		}
		for(int one : table) {
			System.out.println(one);
		}
		boolean flag=false;
		index=0;
		for(int i=0;i<L;i++) {
			if(index>0 && S.charAt(i)!=P.charAt(index)) {
				index = table[index-1];
			}
			if(S.charAt(i)==P.charAt(index)) {
				if(index==l-1) {
					index = table[index];
					flag=true;
					break;
				} else {
					index++;
				}
			}
		}	
		if(flag)
			bw.write("1\n");
		else
			bw.write("0\n");
		bw.flush();
		bw.close();
	}
}
