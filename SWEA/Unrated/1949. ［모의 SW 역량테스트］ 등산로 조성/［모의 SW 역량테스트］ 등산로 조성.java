import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, ans;
	static int[][] map;
	static boolean[][] visited;
	static int dr[] = {1, -1, 0, 0}, dc[] = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			int max = 0;
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						visited[i][j] = true;
						
						dfs(i, j, 1, false);
						
						visited[i][j] = false;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int r, int c, int count, boolean cut) {
		ans = Math.max(count, ans);
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			if(map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				
				dfs(nr, nc, count + 1, cut);
				
				visited[nr][nc] = false;
			}else if(!cut){
				if(map[nr][nc] - K < map[r][c]) {
					int original = map[nr][nc];
					
					map[nr][nc] = map[r][c] - 1;
					
					visited[nr][nc] = true;
					
					dfs(nr, nc, count + 1, true);
					
					visited[nr][nc] = false;
					
					map[nr][nc] = original;
				}
			}
		}
	}
}
