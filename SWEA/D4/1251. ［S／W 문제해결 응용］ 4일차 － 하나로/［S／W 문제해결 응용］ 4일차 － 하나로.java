import java.io.*;
import java.util.*;

public class Solution {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] x = new long[N];
			long[] y = new long[N];
			
			parent = new int[N];
			for(int i = 0; i < N; i++) {
				parent[i] = i;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			int M = N * (N - 1) / 2;
			
			long[][] edge = new long[M][3];
			
			int idx = 0;
			
			for(int i = 0; i < N-1; i++) {
				for(int j = i+1; j < N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					
					edge[idx][0] = i;
					edge[idx][1] = j;
					edge[idx][2] = dx*dx + dy*dy;
					idx++;
				}
			}
			Arrays.sort(edge, (a, b) -> Long.compare(a[2], b[2]));
			
			long sum = 0;
			int cnt = 0;
			
			for(long[] e : edge) {
				if(union((int) e[0], (int) e[1])){
					sum += e[2];
					cnt++;
					if(cnt == N-1) break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(sum * E));
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		parent[b] = a;
		return true;
	}

}
