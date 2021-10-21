import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AverageScore {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		for(int i=0;i<5;i++) {
			int save =Integer.parseInt(br.readLine());
			if(save>40)
				sum+=save;
			else
				sum+=40;
		}
		br.close();
		bw.write(sum/5+"\n");
		bw.flush();
		bw.close();
	}
}
