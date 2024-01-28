import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1064

public class Parallelogram {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[][] point = new int[3][2];
        for (int i = 0; i < 3; i++) {
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        if (checkGradient(point)) {
            System.out.println("-1.0");
        } else {
            double[] length = new double[3];
            for (int i = 0; i < 3; i++) {
                int next = i + 1 > 2 ? 0 : i + 1;
                length[i] = getLength(point[i], point[next]);
            }

            Arrays.sort(length);
            double max = (length[2] + length[1]) * 2;
            double min = (length[0] + length[1]) * 2;
            System.out.println(max - min);
        }
    }

    private static double getLength(int[] a, int[] b) {
        return Math.pow(Math.pow((b[1] - a[1]), 2) + Math.pow((b[0] - a[0]), 2), 0.5);
    }

    private static boolean checkGradient(int[][] point) {
        // 분모가 0이 되는 케이스에서는 유효한 기울기 비교가 어려우므로,
        // 두 직선의 기울기가 같을 때를 가정하여 양 변에 분모를 곱해준 식으로 판정함
        return (point[0][0] - point[1][0]) * (point[0][1] - point[2][1]) == (point[0][1] - point[1][1]) * (point[0][0] - point[2][0]);
    }
}
