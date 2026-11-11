import java.io.*;
import java.util.*;

public class Solution {
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <=  T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int r = N + 2 * K;
			int c = M + 2 * K;
			
			int[][] map = new int[r][c];
			ArrayList<int[]> cell = new ArrayList<>();
			
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int x = Integer.parseInt(st.nextToken());
					map[i+K][j+K] = x;
					if(x > 0) cell.add(new int[] {i+K, j+K, x, 0});
				}
			}
			for (int t = 1; t <= K; t++) {

			    ArrayList<int[]> breed = new ArrayList<>();
			    for (int[] ce : cell) {
			        int x = ce[2];
			        int born = ce[3];
			        if (born + x + 1 == t) breed.add(ce);
			    }

			    breed.sort((a, b) -> Integer.compare(b[2], a[2]));

			    for (int[] ce : breed) {
			        for (int d = 0; d < 4; d++) {
			            int nr = ce[0] + dr[d];
			            int nc = ce[1] + dc[d];
			            if (map[nr][nc] != 0) continue;           
			            map[nr][nc] = ce[2];                     
			            cell.add(new int[]{nr, nc, ce[2], t});    
			        }
			    }
			}

			int answer = 0;
			for (int[] ce : cell) {
			    int x = ce[2];
			    int born = ce[3];
			    if (born + 2 * x > K) answer++;    
			}
			System.out.println("#" + tc + " " + answer);
			
		}
	}
}
