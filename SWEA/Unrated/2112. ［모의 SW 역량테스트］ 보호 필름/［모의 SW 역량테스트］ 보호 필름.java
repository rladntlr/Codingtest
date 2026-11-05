import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K, best;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			best = K;

			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(check());

			dfs(0, 0);

			sb.append("#").append(tc).append(" ").append(best).append("\n");
		}
		System.out.println(sb);
	}

	static boolean check() {
		for(int c = 0; c < W; c++) {
			int run = 1;
			boolean pass = false;

			for(int r = 1; r < D; r++) {
				if(map[r][c] == map[r-1][c]) run++;
				else run = 1;

				if(run >= K ) { pass = true; break;}
			}
			if(!pass) return false;
		}
		return true;
	}

	static void dfs(int depth, int count) {
		if(count >= best) return;

		if(depth == D) {
			if(check()) best = count;
			return;
		}

		dfs(depth + 1, count);

		int[] original = map[depth].clone();

		Arrays.fill(map[depth], 0);
		dfs(depth + 1, count + 1);

		Arrays.fill(map[depth], 1);
		dfs(depth + 1, count + 1);

		map[depth] = original;
	}
}
