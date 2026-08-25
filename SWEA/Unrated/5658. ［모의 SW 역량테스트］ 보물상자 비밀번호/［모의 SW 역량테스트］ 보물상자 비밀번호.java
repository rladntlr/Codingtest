import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String s = br.readLine();

            Deque<Character> dq = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                dq.addLast(s.charAt(i));
            }

            HashSet<String> set = new HashSet<>();

            int div = N / 4;

            for (int rotate = 0; rotate < div; rotate++) {

                StringBuilder cur = new StringBuilder();

                for (char ch : dq) {
                    cur.append(ch);
                }

                for (int k = 0; k < N; k += div) {

                    String str = cur.substring(k, k + div);

                    set.add(str);
                }

                char last = dq.pollLast();
                dq.addFirst(last);
            }

            ArrayList<Integer> ans = new ArrayList<>();

            for (String answer : set) {

                int num = Integer.parseInt(answer, 16);

                ans.add(num);
            }

            Collections.sort(ans, Collections.reverseOrder());

            int result = ans.get(K - 1);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(result)
              .append("\n");
        }

        System.out.print(sb);
    }
}