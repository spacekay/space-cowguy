import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SevenDwarfs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] all = new int[9];
		for(int i=0;i<9;i++)  {
			all[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(all);
		int sum = 0;
		outer:
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					for(int k=0;k<9;k++) {
						if(k!=i&&k!=j) {
							sum+=all[k];
						}
					}
					if(sum==100) {
						for(int k=0;k<9;k++) {
							if(k!=i&&k!=j) {
								bw.write(all[k]+"\n");
							}
						}
						break outer;
					} else {
						sum=0;
					}
				}
			}
		bw.flush();
		bw.close();
	}
}
