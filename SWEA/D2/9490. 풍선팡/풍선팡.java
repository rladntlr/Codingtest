

import java.util.*;
import java.io.*;

public class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    int sum = map[i][j];

                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k <= map[i][j]; k++) {

                            int nr = i + dr[d] * k;
                            int nc = j + dc[d] * k;

                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                                break;
                            }

                            sum += map[nr][nc];
                        }
                    }

                    max = Math.max(sum, max);
                }
            }
            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(max)
                    .append("\n");
        }
        System.out.println(sb);
    }
}
