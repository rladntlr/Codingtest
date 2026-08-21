import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[][] maxi;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static ArrayList<int[]> cores;

    static int maxCore;
    static int minWire;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            maxi = new int[N][N];
            cores = new ArrayList<>();

            maxCore = 0;
            minWire = Integer.MAX_VALUE;

            // 배열 입력
            for (int r = 0; r < N; r++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {

                    maxi[r][c] = Integer.parseInt(st.nextToken());

                    // Core인데 외곽이 아니라면
                    if (maxi[r][c] == 1) {

                        if (r != 0 && r != N - 1 &&
                            c != 0 && c != N - 1) {

                            cores.add(new int[]{r, c});
                        }
                    }
                }
            }

            dfs(0, 0, 0);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(minWire)
              .append("\n");
        }

        System.out.print(sb);
    }


    static void dfs(int idx, int connected, int wireLength) {

        // 모든 Core를 확인했다면
        if (idx == cores.size()) {

            // 더 많은 Core를 연결했다면
            if (connected > maxCore) {

                maxCore = connected;
                minWire = wireLength;

            }

            // 연결 Core 개수가 같다면
            else if (connected == maxCore) {

                minWire = Math.min(minWire, wireLength);
            }

            return;
        }


        // 현재 Core 위치
        int r = cores.get(idx)[0];
        int c = cores.get(idx)[1];


        // 상 하 좌 우
        for (int d = 0; d < 4; d++) {

            int nr = r + dr[d];
            int nc = c + dc[d];

            int cnt = 0;
            boolean possible = true;

            // 1. 갈 수 있는지 확인

            while (nr >= 0 && nr < N &&
                   nc >= 0 && nc < N) {

                // Core 또는 이미 설치된 전선을 만남
                if (maxi[nr][nc] != 0) {

                    possible = false;
                    break;
                }

                cnt++;

                nr += dr[d];
                nc += dc[d];
            }


            // 이 방향으로 갈 수 없다면
            if (!possible) {
                continue;
            }

            // 2. 전선 설치

            nr = r + dr[d];
            nc = c + dc[d];

            while (nr >= 0 && nr < N &&
                   nc >= 0 && nc < N) {

                maxi[nr][nc] = 2;

                nr += dr[d];
                nc += dc[d];
            }

            // 3. 다음 Core 탐색

            dfs(
                idx + 1,
                connected + 1,
                wireLength + cnt
            );

            // 4. 원상복구

            nr = r + dr[d];
            nc = c + dc[d];

            while (nr >= 0 && nr < N &&
                   nc >= 0 && nc < N) {

                maxi[nr][nc] = 0;

                nr += dr[d];
                nc += dc[d];
            }
        }

        // 5. 현재 Core를 연결하지 않는 경우

        dfs(idx + 1, connected, wireLength);
    }
}