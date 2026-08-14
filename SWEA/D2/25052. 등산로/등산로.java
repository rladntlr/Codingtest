import java.util.*;
import java.io.*;

public class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            int[][] H = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; j++) {
                    H[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {

                    int r = i;
                    int c = j;
                    int cnt = 1;

                    while(true) {

                        int min = H[r][c];

                        int nextR = -1;
                        int nextC = -1;

                        for(int d = 0; d < 4; d++) {

                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if(nr >= 0 && nr < N &&
                               nc >= 0 && nc < N) {

                                if(H[nr][nc] < min) {
                                    min = H[nr][nc];
                                    nextR = nr;
                                    nextC = nc;
                                }
                            }
                        }

                        if(nextR == -1) {
                            break;
                        }
                        
                        r = nextR;
                        c = nextC;

                        cnt++;
                    }

                    max = Math.max(max, cnt);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}