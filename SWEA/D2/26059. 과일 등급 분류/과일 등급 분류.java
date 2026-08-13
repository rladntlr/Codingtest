import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int lo = Integer.parseInt(st.nextToken());
			int hi = Integer.parseInt(st.nextToken());
			
			int fruits[] = new int[10001];
			
			st = new StringTokenizer(br.readLine());
			int num = 0;
			for(int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				fruits[num]++;
			}
			
			int sum = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i < fruits.length; i++) {
				sum += fruits[i];
				if(fruits[i] != 0) {
					list.add(sum);
				}		
			}
			
			int ans = Integer.MAX_VALUE;
			
			for(int i = 0; i < list.size() - 1; i++) {
				for(int j = i + 1; j < list.size() - 1; j++) {
					int first = list.get(i);
					int second = list.get(j) - list.get(i);
					int third = N - list.get(j);
					
					if(first < lo || second < lo || third < lo || first > hi || second > hi || third > hi) continue;
					
					int max = Math.max(first, Math.max(second, third));
					int min = Math.min(first, Math.min(second, third));
					
					ans = Math.min(ans, max - min);
				}
			}
			
			if(ans == Integer.MAX_VALUE) ans = -1;
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);

	}

}
