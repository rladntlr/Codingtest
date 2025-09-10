import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
//        map = new char[n][n];
        map = new char[n][];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        divide(0,0, n);
        System.out.println(sb);
    }

    static boolean check(int y, int x, int n) {
        char ch = map[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (ch != map[i][j]) return false;
            }
        }
        return true;
    }

    static void divide(int y, int x, int n) {
        if (check(y, x, n)) {
            sb.append(map[y][x]);
        } else {
            sb.append("(");

            int half = n / 2;

            divide(y, x, half);
            divide(y, x + half, half);
            divide(y + half, x, half);
            divide(y + half, x + half, half);

            sb.append(")");
        }
    }
}
