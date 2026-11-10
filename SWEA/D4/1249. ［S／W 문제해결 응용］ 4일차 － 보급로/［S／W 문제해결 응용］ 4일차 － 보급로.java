import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Solution {
    static int[][] map, dist;
    static int[] dr = {-1, 1, 0, 0}, dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                String s = br.readLine();
                for(int j = 0; j < N; j++){
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            dist = new int[N][N];
            for(int i = 0; i < N; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[0], b[0]));

            dist[0][0] = 0;
            pq.add(new int[]{0, 0, 0});

            while(!pq.isEmpty()){
                int[] cur = pq.poll();

                if(cur[0] > dist[cur[1]][cur[2]]) continue;

                if(cur[1]==N-1 && cur[2]==N-1) break;

                for(int dir = 0; dir < 4; dir++){
                    int nr = cur[1] + dr[dir];
                    int nc = cur[2] + dc[dir];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                    int cost = dist[cur[1]][cur[2]] + map[nr][nc];

                    if(cost < dist[nr][nc]){
                        dist[nr][nc] = cost;
                        pq.add(new int[]{cost, nr, nc});
                    }
                }
            }
            System.out.println("#" + tc + " " + dist[N-1][N-1]);
        }

    }
}