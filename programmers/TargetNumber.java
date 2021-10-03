class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
      // 항상 BFS 문제만 풀었는데, 케이스가 많지 않은 경우라면 재귀로 DFS 푸는 방법도 복습 필요
		DFS(numbers, numbers[0], target, 0);
		DFS(numbers, numbers[0]*(-1), target, 0);
		return answer;
    }
    public static void DFS(int[] numbers, int sum, int target, int level) {
		if(level==numbers.length-1) {
			if(sum==target) {
				answer++;
			}
			return;
		}		
		DFS(numbers, sum+numbers[level+1],target, level+1);
		DFS(numbers, sum-numbers[level+1],target, level+1);	
	}
}
