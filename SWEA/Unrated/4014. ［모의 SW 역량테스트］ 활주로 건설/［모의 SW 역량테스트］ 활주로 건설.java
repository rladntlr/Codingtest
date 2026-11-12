import java.io.*;
import java.util.*;

public class Solution {
	static int N, X;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j <  N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				if(check(map[i])) ans++;
			}
			
			for(int j = 0; j < N; j++) {
				int[] col = new int[N];
				for(int i = 0; i < N; i++) col[i] = map[i][j];
				if(check(col)) ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static boolean check(int line[]) {
		boolean[] use = new boolean[N];
		
		for(int i = 0; i < N-1; i++) {
			if(line[i] == line[i+1]) {
				
			}else if(line[i] == line[i+1] + 1) {	// 내려가기
				for(int j = 0; j < X; j++) {
					int idx = i + 1 + j;
					if(idx < 0 || idx >= N || line[idx] != line[i+1]|| use[idx]) return false;
					use[idx] = true;
				}
			}else if(line[i] == line[i+1] - 1) {	// 올라감
				for(int j = 0; j < X; j++) {
					int idx = i - j;
					if(idx < 0 || idx >= N || use[idx] || line[idx] != line[i]) return false;
					use[idx] = true;
				}
			}else {
				return false;
			}
		}
		return true;
	}
}
