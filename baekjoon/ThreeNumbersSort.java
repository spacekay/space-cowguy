import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2752

public class ThreeNumbersSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a > b) {
            if (b > c) { // a b c
                System.out.println(c + " " + b + " " + a);
            } else if (a > c) { // a c b
                System.out.println(b + " " + c + " " + a);
            } else {
                System.out.println(b + " " + a + " " + c);
            }
        } else {
            if (b < c) { // c b a
                System.out.println(a + " " + b + " " + c);
            } else if (c > a) { // b a
                System.out.println(a + " " + c + " " + b);
            } else {
                System.out.println(c + " " + a + " " + b);
            }
        }
    }
}

