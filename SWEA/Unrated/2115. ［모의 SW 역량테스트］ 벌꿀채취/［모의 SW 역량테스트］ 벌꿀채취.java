import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, C;
    static int[][] map;
    static int[][] profit;

    static int maxProfit;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            profit = new int[N][N];

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1. 각 구간에서 한 일꾼이 얻을 수 있는 최대 수익 계산
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {

                    maxProfit = 0;

                    dfs(r, c, 0, 0, 0);

                    profit[r][c] = maxProfit;
                }
            }

            // 2. 서로 겹치지 않는 구간 2개 선택
            int answer = 0;

            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {

                    for (int r2 = r1; r2 < N; r2++) {
                        for (int c2 = 0; c2 <= N - M; c2++) {

                            // 완전히 같은 구간
                            if (r1 == r2 && c1 == c2) {
                                continue;
                            }

                            // 같은 행인데 겹치는 경우
                            if (r1 == r2) {

                                boolean overlap =
                                        !(c1 + M <= c2 || c2 + M <= c1);

                                if (overlap) {
                                    continue;
                                }
                            }

                            int sum = profit[r1][c1] + profit[r2][c2];

                            answer = Math.max(answer, sum);
                        }
                    }
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }


    // 선택한 M개 벌통에서 최대 수익 계산
    static void dfs(int r, int c, int idx, int sum, int value) {

        // 꿀의 총량이 C를 넘으면 불가능
        if (sum > C) {
            return;
        }

        // M개 벌통을 모두 확인
        if (idx == M) {
            maxProfit = Math.max(maxProfit, value);
            return;
        }

        int honey = map[r][c + idx];

        // 현재 벌통 선택
        dfs(
            r,
            c,
            idx + 1,
            sum + honey,
            value + honey * honey
        );

        // 현재 벌통 선택하지 않음
        dfs(
            r,
            c,
            idx + 1,
            sum,
            value
        );
    }
}