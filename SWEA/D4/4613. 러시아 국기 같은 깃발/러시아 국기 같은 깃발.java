import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][]flag = new char[N][M];
			
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < M; j++) {
					flag[i][j] = s.charAt(j);
				}
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int w = 0; w < N - 2; w++) {
				for(int b = w + 1; b < N - 1; b++) {
					
					int cnt = 0;
					
					for(int i = 0; i <= w; i++) {
						for(int j = 0; j < M; j++) {
							if(flag[i][j] != 'W')
								cnt++;
						}
					}
					for(int i = w + 1; i <= b; i++) {
						for(int j = 0; j < M; j++) {
							if(flag[i][j] != 'B')
								cnt++;
						}
					}
					for(int i = b + 1; i < N; i++) {
						for(int j = 0; j < M; j++) {
							if(flag[i][j] != 'R')
								cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
				
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}
}
