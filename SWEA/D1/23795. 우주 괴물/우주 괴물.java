import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
					
			int rm = 0, cm = 0;
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {
						rm = i;
						cm = j;
					}
				}
			}
			
			for(int d = 0; d < 4; d++) {

			    int nr = rm + dr[d];
			    int nc = cm + dc[d];

			    while(nr >= 0 && nr < N && nc >= 0 && nc < N) {

			        if(arr[nr][nc] == 1) {
			            break;
			        }

			        arr[nr][nc] = 3;

			        nr += dr[d];
			        nc += dc[d];
			    }
			}
			int answer = 0;

			for(int i = 0; i < N; i++) {
			    for(int j = 0; j < N; j++) {
			        if(arr[i][j] == 0) {
			            answer++;
			        }
			    }
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}

}
