import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int total = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {

				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}
			
			
			int left = 0;
			int min = Integer.MAX_VALUE;
			int idx = 0;

			for(int i = 0; i < N - 1; i++) {
			    left += arr[i];

			    int right = total - left;
			    int diff = Math.abs(left - right);

			    if(diff < min) {
			        min = diff;
			        idx = i + 1;
			    }
			}

			sb.append("#").append(tc).append(" ")
			  .append(idx).append(" ")
			  .append(min).append("\n");
		}
		System.out.println(sb);
	}

}
