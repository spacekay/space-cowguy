package datastructure0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		String line = br.readLine();
		br.close();
		int cnt = 0;
		int sum = 0;
		boolean flag = false;
		
		// cnt를 초기화하는 지점, 단어 수를 하나 더 늘리는 지점이 모두 중요함
		for(int i=0;i<m;i++) {
			if(line.charAt(i)=='I' && !flag) {
				flag=true;
				// 여기가 핵심
				if(cnt>=n)
					sum++;
			} else if(line.charAt(i)=='I') {
				flag=true;
				cnt=0;
			} else if(flag) {
				//여기도
				cnt++;
				flag=false;
			} else {
				cnt=0;
				flag=false;
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
}
