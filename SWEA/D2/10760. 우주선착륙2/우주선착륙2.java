import java.util.*;
import java.io.*;
public class Solution {

	static int dr[] = {1, 1, 0, -1, -1, -1, 0, 1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] A = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			 int ans = 0;

	            for(int i = 0; i < N; i++) {
	                for(int j = 0; j < M; j++) {

	                    int num = A[i][j];
	                    int cnt = 0;

	                    for(int d = 0; d < 8; d++) {

	                        int nr = i + dr[d];
	                        int nc = j + dc[d];

	                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
	                            continue;
	                        }

	                        if(A[nr][nc] < num) {
	                            cnt++;
	                        }
	                    }

	                    if(cnt >= 4) {
	                        ans++;
	                    }
	                }
	            }

	            sb.append("#").append(tc).append(" ").append(ans).append("\n");
	        }

	        System.out.print(sb);
	}

}
