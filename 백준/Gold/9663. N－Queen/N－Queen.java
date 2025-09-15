
import java.io.*;

public class Main {
    static boolean[] isused1 = new boolean[40]; // column
    static boolean[] isused2 = new boolean[40]; // / 대각선
    static boolean[] isused3 = new boolean[40]; // \ 대각선
    static int cnt = 0;
    static int n;

    static void func(int cur) { // cur번째 row에 퀸을 놓을 예정
        if (cur == n) { // n개 모두 놓았다면
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) { // (cur, i)에 퀸을 두는 시도
            if (isused1[i] || isused2[i + cur] || isused3[cur - i + n - 1]) continue;

            isused1[i] = true;
            isused2[i + cur] = true;
            isused3[cur - i + n - 1] = true;

            func(cur + 1);

            // 백트래킹 (원상복구)
            isused1[i] = false;
            isused2[i + cur] = false;
            isused3[cur - i + n - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        func(0);
        System.out.println(cnt);
    }
}
