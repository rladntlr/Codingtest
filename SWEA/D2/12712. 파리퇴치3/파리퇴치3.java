import java.util.*;
import java.io.*;

public class Solution {

    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};

    static int xr[] = {1, 1, -1, -1};
    static int xc[] = {-1, 1, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {

                    int plus = arr[i][j];

                    for(int d = 0; d < 4; d++) {

                        for(int k = 1; k < M; k++) {

                            int nr = i + dr[d] * k;
                            int nc = j + dc[d] * k;

                            if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                                break;
                            }

                            plus += arr[nr][nc];
                        }
                    }

                    int cross = arr[i][j];

                    for(int d = 0; d < 4; d++) {

                        for(int k = 1; k < M; k++) {

                            int nr = i + xr[d] * k;
                            int nc = j + xc[d] * k;

                            if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                                break;
                            }

                            cross += arr[nr][nc];
                        }
                    }

                    max = Math.max(max, plus);
                    max = Math.max(max, cross);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}