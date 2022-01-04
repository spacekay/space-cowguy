import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int t = 0;

        int length = A.length;

        for(int i=0; i<length;i++) {
            if(A[t]<B[i]) {
                t++;
                answer++;
            }
        }        
        return answer;
    }
}
