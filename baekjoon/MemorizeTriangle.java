import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MemorizeTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] tri = new int[3];
		for(int i=0;i<3;i++) {
			tri[i]=Integer.parseInt(br.readLine());
		}
    // 입력값 정보가 정확히 무엇인지 한 번 더 보고 코드 작성하기
		if(tri[0]+tri[1]+tri[2]!=180) {
			bw.write("Error\n");
		} else if(tri[0]==tri[1]&&tri[1]==tri[2]) {
			bw.write("Equilateral\n");
		} else if(tri[0]==tri[1]||tri[1]==tri[2]||tri[0]==tri[2]) {
			bw.write("Isosceles\n");
		} else {
			bw.write("Scalene\n");
		} 		
		bw.flush();
		bw.close();
	}
}
