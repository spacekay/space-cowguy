import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Cubeditor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String P = br.readLine();
		br.close();
		int l = P.length();
		int max=0;
		int[] table = new int[l];
		// KMP는 최대 접두사 길이를 구할 때, 무조건 첫 글자부터 세어나감
		// 그러므로 문자열의 중앙에서부터 등장하는 패턴을 검증하고자 한다면
		// 중앙부터 원래 문자열 끝까지 이어지는 문자열을 하나하나 만든 뒤
		// 접두사를 해당 문자열 기준 어디까지 쓸 수 있는지 확인하면 됨
		// 애초에 접미사로 접두사가 한번더 등장해야 index값이 0보다 커지므로 해당 문제 풀이에 사용할 수 있음
		for(int j=0;j<l-1;j++) {
			int index=j;
			for(int i=j+1;i<l;i++) {
				while(index>j && P.charAt(index)!=P.charAt(i)) {
					index = table[index-1];
				}
				if(P.charAt(index)==P.charAt(i)) {
					index++;
					table[i]=index;
					if(index-j>max)
						max=index-j;
				}
			}
			Arrays.fill(table, j+1);
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
