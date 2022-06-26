import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        
        String enter = "님이 들어왔습니다.";
        String out = "님이 나갔습니다.";
        
        // 각 회원의 아이디-닉네임 정보 저장
        HashMap<String, String> idName = new HashMap<>();
        String[][] save = new String[record.length][2];
        int k = 0;
        
        // record 해석
        for(int i=0;i<record.length;i++) {
            String[] lines = record[i].split(" ");
            
            if(lines[0].charAt(0)=='E') {
                save[k][0] = lines[1];
                save[k][1] = lines[0];
                k++;                  
                idName.put(lines[1], lines[2]);
            } else if(lines[0].charAt(0)=='L') {
                save[k][0] = lines[1];
                save[k][1] = lines[0];
                k++;
            } else {
                idName.put(lines[1], lines[2]);
            }
        }
        
        String[] answer = new String[k];
        
        // 결과 출력
        for (int i=0;i<k;i++) {
            String result = idName.get(save[i][0]);
            if(save[i][1].charAt(0)=='E') {
                result += enter;
            } else {
                result += out;
            }
            answer[i] = result;
        }
        return answer;
    }
}
