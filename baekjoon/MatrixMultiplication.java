import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixMultiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] B = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[][] result = new int[n][k];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < k; j++)
                for (int l = 0; l < m; l++)
                    result[i][j] += A[i][l] * B[l][j];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++)
                bw.write(result[i][j] + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
