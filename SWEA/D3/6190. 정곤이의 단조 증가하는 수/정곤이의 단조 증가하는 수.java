import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {

                    int mul = arr[i] * arr[j];

                    String s = String.valueOf(mul);

                    boolean isMono = true;

                    for (int k = 1; k < s.length(); k++) {

                        if (s.charAt(k) < s.charAt(k - 1)) {
                            isMono = false;
                            break;
                        }
                    }

                    if (isMono) {
                        max = Math.max(max, mul);
                    }
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(max)
              .append("\n");
        }

        System.out.print(sb);
    }
}