import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] map;
    static int[][] cnt;
    static boolean[][] visited;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().trim().toCharArray();
            }

            cnt = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        cnt[i][j] = -1;
                        continue;
                    }
                    int mine = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (map[nr][nc] == '*') mine++;
                    }
                    cnt[i][j] = mine;
                }
            }

            visited = new boolean[N][N];
            int click = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cnt[i][j] == 0 && !visited[i][j]) {
                        click++;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cnt[i][j] != -1 && !visited[i][j]) {
                        click++;
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(click).append('\n');
        }
        System.out.print(sb);
    }

    static void bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;                   
                if (cnt[nr][nc] == 0) q.add(new int[]{nr, nc}); 
            }
        }
    }
}