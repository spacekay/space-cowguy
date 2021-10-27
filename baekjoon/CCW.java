import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CCW {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] p = new int[3][2];
		StringTokenizer st;
		for(int l=0;l<3;l++) {
			st = new StringTokenizer(br.readLine()," ");
			p[l][0]=Integer.parseInt(st.nextToken());
			p[l][1]=Integer.parseInt(st.nextToken());
		}
		br.close();
		// 각 변의 길이벡터를 구해서 서로 외적하면 그 크기는 평행사변형의 면적이 된다. (결과적으로)
		int k = (p[1][0]-p[0][0])*(p[2][1]-p[0][1])-(p[1][1]-p[0][1])*(p[2][0]-p[0][0]);
		if(k>0)
			bw.write("1\n");
		else if(k<0)
			bw.write("-1\n");
		else
			bw.write("0\n");
		bw.flush();
		bw.close();
	}
}
