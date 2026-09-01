import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        Deque<Integer> dq = new ArrayDeque<>();

        for (int num : arr) {
            if (dq.isEmpty() || dq.peekLast() != num) {
                dq.addLast(num);
            }
        }

        int[] answer = new int[dq.size()];

        int index = 0;

        while (!dq.isEmpty()) {
            answer[index++] = dq.pollFirst();
        }

        return answer;
    }
}