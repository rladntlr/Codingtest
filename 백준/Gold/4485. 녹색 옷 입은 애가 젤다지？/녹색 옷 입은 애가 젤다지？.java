
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] cost;

    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            map = new int[n][n];
            cost = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = INF;
                }
            }
            cost[0][0] = map[0][0];
            pq.offer(new Vertex(0, 0, map[0][0]));

            while (!pq.isEmpty()) {
                Vertex vertex = pq.poll();

                if (cost[vertex.y][vertex.x] < vertex.c) continue;

                for (int d = 0; d < 4; d++) {
                    int ny = vertex.y + dy[d];
                    int nx = vertex.x + dx[d];
                    if (ny < 0 || nx < 0 || nx >=n || ny >= n) continue;

                    if (cost[ny][nx] > vertex.c + map[ny][nx]) {
                        cost[ny][nx] = vertex.c + map[ny][nx];
                        pq.offer(new Vertex(ny, nx, cost[ny][nx]));
                    }
                }
            }

            sb.append("Problem ").append(tc).append(": ").append(cost[n - 1][n - 1]).append("\n");
            tc++;
        }
        System.out.println(sb);
    }

    static class Vertex {
        int y;
        int x;
        int c;

        Vertex(int y, int x, int c) {
            this.y = y;
            this.c = c;
            this.x = x;
        }
    }
}
