import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String s = br.readLine();

            String str = "NONE";

            for(int i = 0; i <= N - M; i++) {

                boolean isGhlans = true;

                for(int j = 0; j < M / 2; j++) {

                    if(s.charAt(i + j) != s.charAt(i + M - 1 - j)) {
                        isGhlans = false;
                        break;
                    }
                }

                if(isGhlans) {
                    str = s.substring(i, i + M);
                    break;
                }
            }

            sb.append("#")
              .append(test_case)
              .append(" ")
              .append(str)
              .append("\n");
        }

        System.out.print(sb);
    }
}