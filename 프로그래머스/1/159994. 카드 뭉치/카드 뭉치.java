
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> card1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> card2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> ans = new ArrayDeque<>(Arrays.asList(goal));

        while (!ans.isEmpty()) {
            if(!card1.isEmpty() && card1.peekFirst().equals(ans.peekFirst())) {
                card1.pollFirst();
                ans.pollFirst();
            }
            else if(!card2.isEmpty() && card2.peekFirst().equals(ans.peekFirst())) {
                card2.pollFirst();
                ans.pollFirst();
            }
            else break;
        }
        return ans.isEmpty() ? "Yes" : "No";
    }
}
