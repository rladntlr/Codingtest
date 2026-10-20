import java.io.*;
import java.util.*;

public class Solution {
    static final long MOD = 1234567891L;
    static final int MAX = 1000000;
    static long[] fact = new long[MAX + 1];

    public static void main(String[] args) throws IOException {

        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long denom = fact[R] * fact[N - R] % MOD;

            long ans = fact[N] * pow(denom, MOD - 2) % MOD;

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static long pow(long a, long b) {
        long result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) result = result * a % MOD; 
            a = a * a % MOD;                        
            b >>= 1;                                  
        }
        return result;
    }
}