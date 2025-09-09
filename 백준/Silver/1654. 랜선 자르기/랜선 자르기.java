
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static long left, right, mid;
    static int[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        input = new int[k];

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            input[i] = n;
            if(right < n) right = n;
        }
        left = 1;

        while (left <= right) {
            long cnt = 0;
            mid  = (left + right) / 2;

            for(int i = 0; i < k; i++) {
                cnt += input[i]/mid;
            }
            if(cnt >= n) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(right);
//        System.out.println(left-1);
    }
}
