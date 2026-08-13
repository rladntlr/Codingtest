
import java.util.*;
import java.io.*;

public class  Solution {
	
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] puzzle = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			for(int i = 0; i < N; i++) {
			    for(int j = 0; j < N; j++) {

			        if(puzzle[i][j] == 1) {

			            for(int d = 0; d < 2; d++) {

			                int prevR = i - dr[d];
			                int prevC = j - dc[d];

			                if(prevR >= 0 && prevR < N &&
			                   prevC >= 0 && prevC < N &&
			                   puzzle[prevR][prevC] == 1) {
			                    continue;
			                }

			                int nr = i;
			                int nc = j;
			                int cnt = 0;

			                while(nr >= 0 && nr < N &&
			                      nc >= 0 && nc < N &&
			                      puzzle[nr][nc] == 1) {

			                    cnt++;

			                    nr += dr[d];
			                    nc += dc[d];
			                }

			                if(cnt == K) {
			                    ans++;
			                }
			            }
			        }
			    }
			}
		sb.append("#").append(tc).append(" ").append(ans).append("\n");
	}
		System.out.println(sb);
	}

}
