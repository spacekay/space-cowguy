import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2480

public class ThreeDice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();
        if (a == b && b == c) {
            bw.write((10000 + a * 1000) + "\n");
        } else if (a == b || a == c) {
            bw.write((1000 + a * 100) + "\n");
        } else if (b == c) {
            bw.write((1000 + 100 * b) + "\n");
        } else {
            bw.write(Math.max(Math.max(a, b), c) * 100 + "\n");
        }
        bw.flush();
        bw.close();
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] A = bufferedReader.readLine().split(" ");

        int a = Integer.parseInt(A[0]);
        int b = Integer.parseInt(A[1]);
        int c = Integer.parseInt(A[2]);

        if (a == b && b == c) {
            System.out.println(10000 + a * 1000);
        } else if (a == b || b == c || a == c) {
            if (a == b) {
                System.out.println(1000 + a * 100);
            } else if (b == c) {
                System.out.println(1000 + b * 100);
            } else if (a == c) {
                System.out.println(1000 + c * 100);
            }
        } else {
            System.out.println(Math.max(a, Math.max(b, c)) * 100);
        }


    }
}
*/
