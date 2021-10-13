import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 그리디 알고리즘 문제!
public class LostBracket {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		br.close();
		int L = line.length();
		int[] arr = new int[51];
		ArrayList<Boolean> list = new ArrayList<>();
		String save="";
		int t=0;
		for(int i=0;i<L;i++) {
			char now = line.charAt(i);
			if(now>='0' && now<='9') {
				save+=now;
			} else if(now=='-') {
				arr[t]=Integer.parseInt(save);
				t++;
				save="";
				list.add(false);
			} else if(now=='+') {
				arr[t]=Integer.parseInt(save);
				t++;
				save="";
				list.add(true);
			} 
		}
		arr[t]=Integer.parseInt(save);
		int sum=arr[0];
		//L = list.size();
		// -가 나오고 난 바로 뒤의 +는 다 -로 처리
		// 그 다음 나오는 -는 그대로 -로 처리
		// 이후 모든 항을 빼기로 진행할 수 있음
		boolean flag=false;
		for(int i=0;i<t;i++) {
			if(list.get(i)&&!flag) {
				sum+=arr[i+1];
			} else if(!list.get(i)&&!flag) {
				sum-=arr[i+1];
				flag=true;
			} else if(list.get(i)&&flag) {
				sum-=arr[i+1];
			} else {
				// 뒤에 있는 건 영원히 - 연산만 해야함!
				sum-=arr[i+1];
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	} 
}
