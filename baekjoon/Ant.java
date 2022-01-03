import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ant {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		br.close();

		int nx = (p+t)%(w*2);
		int ny = (q+t)%(h*2);
		// w*2나 h*2의 나머지를 구하는 이유는..
		// 아래로 내려올 때는 중심점을 기준으로 나머지 값과 대칭인 점에 위치해야 하기 때문이다. (예제 2가 해당 케이스 검증 가능)
		
		if(nx>w)
			nx = w*2 - nx;
		if(ny>h)
			ny = h*2 - ny;
		
		bw.write(nx+" "+ny+"\n");
		bw.flush();
		bw.close();
	}
}
