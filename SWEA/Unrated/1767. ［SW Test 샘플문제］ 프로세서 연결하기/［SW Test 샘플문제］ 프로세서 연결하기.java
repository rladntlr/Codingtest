
import java.io.*;
import java.util.*;

public class Solution {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int map[][];
    static ArrayList<int[]> core;
    static int N, max, min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = 0;
            min = Integer.MAX_VALUE;
            core = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            core.add(new int[]{i, j});
                        }
                    }
                }

            }
            dfs(0, 0, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    static void dfs(int depth, int conn, int length) {
        if (conn + (core.size() - depth) < max) return;
        
        if (depth == core.size()) {
            if (conn > max) {
                max = conn;
                min = length;
            } else if (conn == max) {
                min = Math.min(length, min);
            }
            return;
        }
        int r = core.get(depth)[0];
        int c = core.get(depth)[1];

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            int cnt = 0;
            boolean possible = true;

            while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] != 0) {
                    possible = false;
                    break;
                }

                cnt++;

                nr += dr[dir];
                nc += dc[dir];
            }

            if (!possible) {
                continue;
            }

            nr = r + dr[dir];
            nc = c + dc[dir];

            while (nr >= 0 && nr < N &&
                    nc >= 0 && nc < N) {

                map[nr][nc] = 2;

                nr += dr[dir];
                nc += dc[dir];
            }

            // 3. 다음 Core 탐색

            dfs(
                    depth + 1,
                    conn + 1,
                    length + cnt
            );


            nr = r + dr[dir];
            nc = c + dc[dir];

            while (nr >= 0 && nr < N &&
                    nc >= 0 && nc < N) {

                map[nr][nc] = 0;

                nr += dr[dir];
                nc += dc[dir];
            }
        }
        dfs(depth+1, conn, length);
    }
}
