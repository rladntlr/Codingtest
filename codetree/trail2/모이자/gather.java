import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {         
            int sum = 0;
            for (int i = 1; i <= n; i++) {      
                sum += a[i] * Math.abs(i - j);
            }
            answer = Math.min(answer, sum);
        }

        System.out.println(answer);
    }
}