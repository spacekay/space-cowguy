package org.spacekay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// 1417

public class AssemblyElection {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int a = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> others = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < n - 1; i++) {
      others.add(Integer.parseInt(br.readLine()));
    }
    br.close();

    int count = 0;
    while (true) {
      boolean innerFlag = false;
      for (int i = 0; i < n - 1; i++) {
        if (others.isEmpty()) {
          break;
        }
        // 오히려 others.peek()가 a + count보다 작을 때만 로직이 돌도록 처리하면 worst case에서 더 빨라질 수 있음.
        if (others.peek() >= a + count) {
          innerFlag = true;
          others.add(others.poll() - 1);
          count++;
        }
      }
      if (!innerFlag) {
        break;
      }
    }

    bw.write(count + "\n");
    bw.flush();
    bw.close();
  }
}
