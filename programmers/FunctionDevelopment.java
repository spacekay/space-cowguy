import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
      
        // 각 기능별 개발 소요 일자를 Queue에 넣음
        for(int i=0;i<speeds.length;i++) {
            q.offer((int) Math.ceil((double) (100-progresses[i])/speeds[i]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        int prev = q.poll();
        
        // 앞 기능의 소요 일자보다 빠른 것들은 함께 발표하고,
        // 느린 것들은 이후에 발표함
        while(!q.isEmpty()) {
            if(prev < q.peek()) {
                list.add(count);
                prev = q.poll();
                count=1;
            } else {
                q.poll();
                count++;
            }
        }
        
        // 편의상 사용한 ArrayList를 Array(요구 output)로 옮김
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++) {
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}
