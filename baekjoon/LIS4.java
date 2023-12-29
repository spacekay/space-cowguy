import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 14002, 14003

public class LIS4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        // 인덱스가 LIS임 (원소는 가장 끝에 존재하는 숫자)
        int[] length = new int[n];
        int[] index = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        length[0] = arr[0];
        index[0] = 0;
        int max = 1;
        // 각 인덱스마다 자신의 왼쪽에서 자기보다 작을 수 있는 케이스를 다 검색
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            if (length[max - 1] < key) {
                max++;
                length[max - 1] = key;
                index[i] = max - 1;
            } else {
                // 탐색용 배열을 length 배열로 했어야 한다..
                int mid = search(key, max, length);
                length[mid] = key;
                index[i] = mid;
            }
        }
        bw.write(max + "\n");
        int[] LIS = new int[max + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] + 1 == max) {

                LIS[max] = arr[i];
                max -= 1;
            }
        }
        for (int i = 1; i < LIS.length; i++) {
            bw.write(LIS[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    // length보다 짧은 거리에 있는 수열의 가장 오른쪽 숫자 중 현재 주어진 숫자보다 더 큰 숫자인 경우를 찾고
    // 현재의 숫자로 대체해 줌
    // length 배열은 값이 오름차순이라고 가정할 수 있어서 이분탐색 가능
    public static int search(int num, int length, int[] LIS) {
        int lt = 0;
        int rt = length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (LIS[mid] < num) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return lt;
    }
}
