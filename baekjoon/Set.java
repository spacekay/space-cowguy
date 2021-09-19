import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Set {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> all = new HashSet<>();
		for(int i=1;i<=20;i++) {
			all.add(i);
		}
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			String select=st.nextToken();
			int num=0;
			if(st.hasMoreTokens())
				num = Integer.parseInt(st.nextToken());
			if(select.equals("add")) {
				set.add(num);
			} else if (select.equals("remove")) {
				set.remove(num);
			} else if (select.equals("check")) {
				if(set.contains(num)) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			} else if (select.equals("toggle")) {
				if(set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
			} else if (select.equals("all")) {
				set.addAll(all);
			} else if (select.equals("empty")) {
				set.clear();
			} 
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
