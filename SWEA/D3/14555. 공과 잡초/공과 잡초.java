
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			boolean[] ball = new boolean[str.length()];
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c=='(') {
					ball[i] = true;
				}
				else if(c==')') {
					ball[i-1] = true;
				}
			}
			int cnt = 0;
			
			for(int i = 0; i < ball.length; i++) {
				if(ball[i]) {
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}
