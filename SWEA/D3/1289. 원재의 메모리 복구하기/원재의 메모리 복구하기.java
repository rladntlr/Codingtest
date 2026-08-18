import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			int cnt = 0;
			char basic = '0';
			for(char c : str.toCharArray()) {
				if(c!=basic) {
					cnt++;
					basic = c;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
