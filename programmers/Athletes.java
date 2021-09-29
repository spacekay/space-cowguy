import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int l=completion.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<l;i++) {
            map.put(completion[i],map.getOrDefault(completion[i],0)+1);
        }
        
        for(int i=0;i<=l;i++) {
            if(map.containsKey(participant[i])) {
                int save;
                if((save=map.get(participant[i]))>0) {
                    map.put(participant[i],save-1);
                } else {
                    answer=participant[i];
                    break;
                }     
            } else {
                answer=participant[i];
                break;
            }
        }
        return answer;
    }
}
