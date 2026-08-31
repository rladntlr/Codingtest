import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			BigInteger A = new BigInteger(st.nextToken());
			
			BigInteger B = new BigInteger(st.nextToken());
			
			sb.append("#").append(tc).append(" ").append(A.add(B)).append("\n");
		}

		System.out.print(sb);

	}

}
