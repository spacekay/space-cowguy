import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 15803

public class Bottlegrounds {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // int -> double 에서는 오차가 발생할 수 있음
        // 차라리 자료형을 유지하는 것이 오차를 줄일 수 있음
        double[][] save = new double[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            save[i][0] = Double.parseDouble(st.nextToken());
            save[i][1] = Double.parseDouble(st.nextToken());
        }
        br.close();

        double a1 = save[1][0] - save[0][0];
        double a2 = save[2][0] - save[1][0];
        double b1 = save[1][1] - save[0][1];
        double b2 = save[2][1] - save[1][1];

        if (a1 == 0 && a2 == 0) {
            bw.write("WHERE IS MY CHICKEN?\n");
        } else if (a1 == 0 || a2 == 0 || (b1 / a1) != (b2 / a2)) {
            bw.write("WINNER WINNER CHICKEN DINNER!\n");
        } else {
            bw.write("WHERE IS MY CHICKEN?\n");
        }

        bw.flush();
        bw.close();
    }
}
