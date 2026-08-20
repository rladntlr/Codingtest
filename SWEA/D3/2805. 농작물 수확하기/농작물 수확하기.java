import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
			int sum = 0; 
			int mid = N / 2;
			
			for(int i = 0; i < N; i++) {
				int range = mid - Math.abs(mid - i);	// 0, 1, 2, 1, 0
				for(int j = mid - range; j <= mid + range; j++) {	 // 2~2, 1~3, 0~4 ...
					sum += farm[i][j];
				}
			}
			sb.append("#")
			  .append(tc)
			  .append(" ")
			  .append(sum)
			  .append("\n");
		}
		System.out.println(sb);
	}
}
