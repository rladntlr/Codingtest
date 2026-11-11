import java.io.*;
import java.util.*;

public class Solution {
	static int[] dr= {0, -1, 1, 0, 0}, dc = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] micro = new int[K][4];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				micro[i][0] = Integer.parseInt(st.nextToken());	// r
				micro[i][1] = Integer.parseInt(st.nextToken());	// c
				micro[i][2] = Integer.parseInt(st.nextToken());	// 수
				micro[i][3] = Integer.parseInt(st.nextToken());	// 방향
			}
			
			for(int i = 1; i <= M; i++) {
				
				for(int j = 0; j < K; j++) {
					if(micro[j][2] == 0) continue;
					micro[j][0] = micro[j][0] + dr[micro[j][3]];
					micro[j][1] = micro[j][1] + dc[micro[j][3]];
					
					if(micro[j][0] == 0 || micro[j][0] == N-1 || micro[j][1] == 0 || micro[j][1] == N-1) {
						micro[j][2] /= 2;
						if(micro[j][3] == 1) micro[j][3] = 2;
						else if(micro[j][3] == 2) micro[j][3] = 1;
						else if(micro[j][3] == 3) micro[j][3] = 4;
						else micro[j][3] = 3;
					}
				}
				int[][] sum = new int[N][N];
				int[][] max = new int[N][N];
				int[][] owner = new int[N][N];

				for (int j = 0; j < K; j++) {
				    if (micro[j][2] == 0) continue;     

				    int r = micro[j][0];
				    int c = micro[j][1];

				    sum[r][c] += micro[j][2];         

				    if (micro[j][2] > max[r][c]) {      
				        max[r][c] = micro[j][2];
				        owner[r][c] = j;               
				    }
				}

				for (int j = 0; j < K; j++) {
				    if (micro[j][2] == 0) continue;

				    int r = micro[j][0];
				    int c = micro[j][1];

				    if (owner[r][c] == j) micro[j][2] = sum[r][c];
				    else micro[j][2] = 0;
				}
			}
			int ans = 0;
			for(int i = 0; i < K; i++) ans += micro[i][2];
			System.out.println("#" + tc + " " + ans	);
			
			
		}
	}
}
