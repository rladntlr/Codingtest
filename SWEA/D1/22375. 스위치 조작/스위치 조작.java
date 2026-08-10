import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] first = new int[N];
			int[] last = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				first[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				last[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				if(first[i] != last[i]) {
					ans++;
					for(int j = i; j < N; j++) {
						first[j] = 1 - first[j];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

}
