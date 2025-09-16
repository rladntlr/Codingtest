import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, sy, sx, sSize, sEatCnt, ans;
    static int[][] map;

    static Queue<Node> q = new ArrayDeque<>();
    static boolean[][] visit;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 9) {
                    sy = i; sx = j;
                }
                map[i][j] = n;
            }
        }

        sSize = 2;

        while (true) {
            int dist = bfs();
            if (dist == 0) break;
            ans += dist;

        }

        System.out.println(ans);
    }

    static int bfs() {
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }

        visit[sy][sx] = true;
        q.offer(new Node(sy, sx, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int d = node.d;

            if (map[y][x] != 0 && map[y][x] < sSize) {
                if (d < minDist) {
                    minDist = d;
                    minY = y;
                    minX = x;
                } else if (d == minDist) {
                    if (y < minY) {
                        minDist = d;
                        minY = y;
                        minX = x;
                    } else if (y == minY) {
                        if (x < minX) {
                            minDist = d;
                            minY = y;
                            minX = x;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx] || map[ny][nx] > sSize) continue;
                visit[ny][nx] = true;
                q.offer(new Node(ny, nx, node.d + 1));
            }
        }
        if (minDist == Integer.MAX_VALUE) return 0;
        else {
            sEatCnt++;
            if (sEatCnt == sSize) {
                sSize++;
                sEatCnt = 0;
            }
            map[minY][minX] = 0;
            map[sy][sx] = 0;

            sy = minY;
            sx = minX;
        }
        return minDist;
    }

    static class Node {
        int y, x, d;

        Node(int y, int x, int d) {
            this.y = y; this.x = x; this.d = d;
        }
    }
}
