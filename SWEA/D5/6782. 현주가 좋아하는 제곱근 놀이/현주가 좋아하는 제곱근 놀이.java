import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            long N = Long.parseLong(br.readLine());
            long count = 0;

            while (N > 2) {

                long root = (long) Math.sqrt(N);

                // N이 완전제곱수가 아니라면
                // N보다 큰 가장 가까운 제곱수의 제곱근을 찾음
                if (root * root < N) {
                    root++;
                }

                count += root * root - N;

                count++;

                N = root;
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(count)
              .append("\n");
        }

        System.out.print(sb);
    }
}