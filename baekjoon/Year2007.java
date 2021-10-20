import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Year2007 {
// 깔끔한 코드 만들기에 집중
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		br.close();
		String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		int dayAll = 0;
		for(int i=0;i<x;i++) {
			if(i==x-1) {
				dayAll+=y;
			} else {
				dayAll+=month[i];
			}
		}
		bw.write(day[dayAll%7]+"\n");
		bw.flush();
		bw.close();
	}
}
