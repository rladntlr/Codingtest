import java.io.*;
import java.util.*;

public class Main {

    // 방향 벡터 (상, 하, 좌, 우)
    static int[] dy = {-1, 1, 0, 0}; // 행(y) 이동
    static int[] dx = {0, 0, -1, 1}; // 열(x) 이동
    static int n; // 행 개수 (세로)
    static int m; // 열 개수 (가로)
    static int[][] matrix;
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // M: 열(x), N: 행(y)
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 열
        n = Integer.parseInt(st.nextToken()); // 행
        matrix = new int[n][m]; // [행][열]
        queue = new ArrayDeque<>();

        // 입력
        for (int y = 0; y < n; y++) {          // 행
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {      // 열
                matrix[y][x] = Integer.parseInt(st.nextToken());
                if (matrix[y][x] == 1) {
                    queue.add(new int[]{y, x}); // (행, 열)
                }
            }
        }

        BFS();

        // 결과 계산
        int result = Integer.MIN_VALUE;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (matrix[y][x] == 0) { // 아직 안 익음
                    System.out.println("-1");
                    return;
                }
                result = Math.max(result, matrix[y][x]);
            }
        }
        System.out.println(result - 1);
        br.close();
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0]; // 행
            int x = current[1]; // 열

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d]; // 행 이동
                int nx = x + dx[d]; // 열 이동

                // 범위 체크
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (matrix[ny][nx] != 0) continue;

                matrix[ny][nx] = matrix[y][x] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}