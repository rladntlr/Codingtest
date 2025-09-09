import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
      HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        HashMap<String, String> uid = new HashMap<>();

        for (String s : record) {
            String[] split = s.split(" ");
            if (split.length == 3) {
                uid.put(split[1], split[2]);
            }
        }
        ArrayList<String> ans = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            if(msg.containsKey(split[0])){
                ans.add(uid.get(split[1]) + msg.get(split[0]));
            }
        }
        return ans.toArray(new String[0]);
    }
}