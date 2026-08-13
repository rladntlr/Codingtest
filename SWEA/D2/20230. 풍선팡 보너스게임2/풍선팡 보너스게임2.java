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
			
			int[][] A = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int sum = A[i][j];
					
					
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							sum += A[nr][nc];
							
							nr += dr[d];
							nc += dc[d];
						}
					}
					if(max < sum) {
						max = sum;
					}
				}
				
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
			System.out.println(sb);
	}
}
