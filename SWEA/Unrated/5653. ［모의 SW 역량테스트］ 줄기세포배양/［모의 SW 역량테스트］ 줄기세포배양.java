

import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M, K;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int R = N + 2 * K;
			int C = M + 2 * K;
			
			int[][] life = new int [R][C];
			int[][] born = new int [R][C];
			
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int cell = Integer.parseInt(st.nextToken());
					
					if(cell != 0) {
						life[i + K][j + K] = cell;
						born[i + K][j + K] = 0;
					}
				}
			}
			
			for(int time = 1; time <= K; time++) {
				
				int[][] next = new int[R][C];

			    for(int i = 0; i < R; i++) {

			        for(int j = 0; j < C; j++) {

			            if(life[i][j] == 0) {
			                continue;
			            }

			            if(life[i][j] + born[i][j] + 1 == time) {

			                for(int d = 0; d < 4; d++) {

			                    int nr = i + dr[d];
			                    int nc = j + dc[d];

			                    if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
			                        continue;
			                    }

			                    if(life[nr][nc] != 0) {
			                        continue;
			                    }

			                    next[nr][nc] =
			                        Math.max(next[nr][nc], life[i][j]);
			                }
			            }
			        }
			    }

			    for(int i = 0; i < R; i++) {

			        for(int j = 0; j < C; j++) {

			            if(next[i][j] != 0) {
			                life[i][j] = next[i][j];
			                born[i][j] = time;
			            }
			        }
			    }
			}
			   int ans = 0;

	            for (int i = 0; i < R; i++) {

	                for (int j = 0; j < C; j++) {

	                    if (life[i][j] == 0) {
	                        continue;
	                    }

	                    int deadTime =
	                            born[i][j] + 2 * life[i][j];

	                    if (deadTime > K) {
	                        ans++;
	                    }
	                }
	            }


	            sb.append("#")
	              .append(tc)
	              .append(" ")
	              .append(ans)
	              .append("\n");
	        }

	        System.out.print(sb);
	        }
	}
	
