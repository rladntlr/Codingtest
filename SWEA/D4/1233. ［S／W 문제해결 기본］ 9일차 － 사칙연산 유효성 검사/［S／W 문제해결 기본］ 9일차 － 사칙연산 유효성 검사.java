import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {

            int N = Integer.parseInt(br.readLine());
            int ans = 1;

            for (int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                int node = Integer.parseInt(st.nextToken());
                String value = st.nextToken();

                // 왼쪽 자식조차 없으면 리프 노드
                boolean isLeaf = node * 2 > N;

                boolean isOperator =
                        value.equals("+") ||
                        value.equals("-") ||
                        value.equals("*") ||
                        value.equals("/");

                if (isLeaf) {
                    // 리프 노드는 숫자여야 함
                    if (isOperator) {
                        ans = 0;
                    }

                } else {
                    // 리프가 아닌 노드는 연산자여야 함
                    if (!isOperator) {
                        ans = 0;
                    }

                    // 연산자는 자식이 반드시 2개여야 함
                    if (node * 2 + 1 > N) {
                        ans = 0;
                    }
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(ans)
              .append("\n");
        }

        System.out.print(sb);
    }
}