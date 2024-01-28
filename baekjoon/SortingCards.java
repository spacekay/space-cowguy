import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1715

public class SortingCards {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int first, second;
        int count = 0;
        while (!pq.isEmpty()) {
            first = pq.poll();
            if (pq.isEmpty()) {
                break;
            }
            second = pq.poll();
            count += (first + second);
            pq.add(first + second);
        }
        System.out.println(count);
    }
}
