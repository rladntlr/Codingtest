

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r, c, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());       //2^n
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        n = 1 << n;  // 2^n으로 초기화

        int x = 0, y = 0;

        while (n > 1) {
            n /= 2;  // 절반으로 줄임

            // 왼쪽 위
            if(r < y + n && c < x + n) {
                // ans += 0 (아무것도 안 함)
            }
            // 오른쪽 위
            else if (r < y + n && c >= x + n) {
                ans += n * n * 1;
                x += n;
            }
            // 왼쪽 아래
            else if (r >= y + n && c < x + n) {  // 수정: r >= y + n
                ans += n * n * 2;
                y += n;
            }
            // 오른쪽 아래
            else {
                ans += n * n * 3;  // 수정: n * n * 3
                y += n;
                x += n;
            }
        }
        System.out.println(ans);
    }
}