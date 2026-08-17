import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static char[][] map;

    static int[] dr = {0, 1, 1, 1};
    static int[] dc = {1, 0, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            map = new char[N][N];

            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
            }

            boolean found = false;

            for (int r = 0; r < N && !found; r++) {

                for (int c = 0; c < N && !found; c++) {

                    if (map[r][c] != 'o') {
                        continue;
                    }

                    for (int d = 0; d < 4; d++) {

                        int count = 1;

                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        while (nr >= 0 && nr < N &&
                               nc >= 0 && nc < N &&
                               map[nr][nc] == 'o') {

                            count++;

                            if (count >= 5) {
                                found = true;
                                break;
                            }

                            nr += dr[d];
                            nc += dc[d];
                        }

                        if (found) {
                            break;
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ");

            if (found) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}