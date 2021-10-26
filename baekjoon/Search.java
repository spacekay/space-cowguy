package string0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 어렵다. 미완성임
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
		index=0;
		int cnt=0;
		int start=0;
		int tmpstart=0;
		boolean flag=false;
		int t=0;
		for(int i=0;i<L;i++) {			
			if(index>0&& P.charAt(index)!=S.charAt(i)) {
				index = table[index-1];
				flag=false;
				//System.out.println(i+" "+S.charAt(i));
			}
			if(P.charAt(index)==S.charAt(i)) {
				if(!flag) {
					tmpstart=t;
					//System.out.println(i+" "+S.charAt(i));
					index++;
					flag=true;
				} else if(index==l-1) {
					start=tmpstart;
					index=0;
					flag=false;
					cnt++;
				} else {
					index++;
				}
			}
			if(S.charAt(i)!=' ')
				t++;
		}
		bw.write(cnt+"\n");
		//if()
		bw.write((start+1)+"\n");
		bw.flush();
		bw.close();
	}

}
