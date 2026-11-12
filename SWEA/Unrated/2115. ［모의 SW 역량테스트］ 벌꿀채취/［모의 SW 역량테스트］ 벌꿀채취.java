import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, C, max, best;
	static int[][] map, maxVal;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			maxVal = new int[N][N];
			max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= N - M; j++) {
					best = 0;
					dfs(i, j, 0, 0, 0);
					maxVal[i][j] = best;
				}
			}
			for(int i1 = 0; i1 < N; i1++) {
				for(int i2 = 0; i2 <= N - M; i2++) {
					
					for(int r1 = 0; r1 < N; r1++) {
						for(int r2 = 0; r2 <= N - M; r2++) {
							if(i1 == r1 && r2 < i2 + M) continue;
							
							max = Math.max(max, maxVal[i1][i2] + maxVal[r1][r2]);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	static void dfs(int r, int c, int idx, int sumHoney, int sumMoney) {
		if(sumHoney > C) return;
		
		if(idx == M) {
			best = Math.max(best, sumMoney);
			return;
		}
		int honey = map[r][c + idx];
		dfs(r, c, idx + 1, sumHoney + honey, sumMoney + honey*honey);
		dfs(r, c, idx + 1, sumHoney, sumMoney);
	}
}
