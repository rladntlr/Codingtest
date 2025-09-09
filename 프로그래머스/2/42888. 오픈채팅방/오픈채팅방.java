import java.util.HashMap;
import java.util.StringTokenizer;
class Solution {
    public String[] solution(String[] record) {
       HashMap<String, String> uid = new HashMap<>();

        for(int i = 0; i < record.length; i++){
            char first = record[i].charAt(0);
            if (first == 'E' || first == 'C') {
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                uid.put(st.nextToken(), st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < record.length; i++){
            char first = record[i].charAt(0);
            if (first == 'E' || first == 'L') {
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                sb.append(uid.get(st.nextToken())).append( first == 'E' ? "님이 들어왔습니다.," : "님이 나갔습니다.,");
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString().split(",");
    }
}