import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Belt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		// double은 자릿수가 늘어날수록 불안정해짐
		int[][] wheels = new int[m][3];
		for(int l=0;l<m;l++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			wheels[l][0]=Integer.parseInt(st.nextToken());
			wheels[l][1]=Integer.parseInt(st.nextToken());
			wheels[l][2]=Integer.parseInt(st.nextToken());
		}
		br.close();
		
		// Overflow 주의
		long spin = 1;
		boolean clockwise = true;
		for(int i=0;i<m;i++) {
			if(wheels[i][2]==1 && clockwise)
				clockwise = false;
			else if(wheels[i][2]==1)
				clockwise = true;
			spin *= wheels[i][1];
			spin /= wheels[i][0];
		}
		
		if(clockwise)
			bw.write("0 ");
		else
			bw.write("1 ");
		bw.write(spin+"\n");
		
		bw.flush();
		bw.close();
	}
}
