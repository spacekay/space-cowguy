import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 19532

public class VirtualLecture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[6];

        for (int i = 0; i < 6; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // 값을 변수로 가져와서 연산하면 더 빠른듯 하나...
        int x = (numbers[2] * numbers[4] - numbers[5] * numbers[1]) / (numbers[0] * numbers[4] - numbers[3] * numbers[1]);
        int y = (numbers[2] * numbers[3] - numbers[5] * numbers[0]) / (numbers[1] * numbers[3] - numbers[4] * numbers[0]);

        bw.write(x + " " + y + "\n");
        bw.flush();
        bw.close();
    }

    private static int gcd(int x, int y) {
        int z;
        while (y != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
}

/*
 *
 * import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 19532

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[6];

        for (int i = 0; i < 6; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int A, B, C, D, E, F, x, y;
        if (numbers[0] == 0) {
            y = numbers[2] / numbers[1];
            if (numbers[4] == 0) {
                x = numbers[5] / numbers[3];
            } else {
                B = gcd(numbers[1], numbers[4]) * numbers[1] * numbers[4];
                C = B / numbers[1] * numbers[2];
                D = B / numbers[4] * numbers[3];
                F = B / numbers[4] * numbers[5];
                x = (F - C) / D;
            }
        } else if (numbers[1] == 0) {
            x = numbers[2] / numbers[0];
            if (numbers[3] == 0) {
                y = numbers[5] / numbers[4];
            } else {
                A = gcd(numbers[0], numbers[3]) * numbers[0] * numbers[3];
                C = A / numbers[0] * numbers[2];
                E = A / numbers[3] * numbers[4];
                F = A / numbers[3] * numbers[5];
                y = (F - C) / E;
            }
        } else if (numbers[3] == 0) {
            y = numbers[5] / numbers[4];
            B = gcd(numbers[1], numbers[4]) * numbers[1] * numbers[4];
            F = B / numbers[4] * numbers[5];
            A = B / numbers[1] * numbers[0];
            C = B / numbers[1] * numbers[2];
            x = (C - F) / A;
        } else if (numbers[4] == 0) {
            x = numbers[5] / numbers[3];
            A = gcd(numbers[0], numbers[3]) * numbers[0] * numbers[3];
            B = A / numbers[0] * numbers[1];
            C = A / numbers[0] * numbers[2];
            F = A / numbers[3] * numbers[5];
            y = (C - F) / B;
        } else {
            A = gcd(numbers[0], numbers[3]) * numbers[0] * numbers[3];
            B = A / numbers[0] * numbers[1];
            C = A / numbers[0] * numbers[2];
            E = A / numbers[3] * numbers[4];
            F = A / numbers[3] * numbers[5];
            y = (C - F) / (B - E);

            B = gcd(numbers[1], numbers[4]) * numbers[1] * numbers[4];
            A = B / numbers[1] * numbers[0];
            C = B / numbers[1] * numbers[2];
            D = B / numbers[4] * numbers[3];
            F = B / numbers[4] * numbers[5];
            x = (C - F) / (A - D);
        }

        bw.write(x + " " + y + "\n");
        bw.flush();
        bw.close();
    }

    private static int gcd(int x, int y) {
        int z;
        while (y != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
}

 * */
