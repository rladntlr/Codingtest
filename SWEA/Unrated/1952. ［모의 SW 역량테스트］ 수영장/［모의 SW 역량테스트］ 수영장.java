import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int[] dp = new int[13];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= 12; i++) {
                int plan = Integer.parseInt(st.nextToken());

                dp[i] = dp[i - 1] + Math.min(plan * day, month);

                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + three);
                }
            }

            int ans = Math.min(dp[12], year);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }
}