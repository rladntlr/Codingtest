import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
//				System.out.print(A[i] + " ");
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
//				System.out.print(B[i] + " ");
			}
			int sum = 0, max = 0;
			if(M > N) {

				for(int i = 0; i <= M-N; i++) {
					sum = 0;
					for(int j = 0; j < N; j++) {
						sum += A[j] * B[i + j];
					}
					if(max < sum) {
						max = sum;
					}
				}
				
			}else if(N > M) {

				for(int i = 0; i <= N - M; i++) {
					sum = 0;
					for(int j = 0; j < M; j++) {
						sum += A[i + j] * B[j];
						
					}
					if(max < sum) {
						max = sum;
					}
				}
				
			}else {
					for(int j = 0; j < N; j++) {
						sum += A[j] * B[j];
						if(max < sum) {
							max = sum;
						}
					}
					
				
			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}
