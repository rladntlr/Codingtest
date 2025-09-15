
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, ans;
    static char[][] map;

    static int[] dy = {-1, 0, 1};       // 우상 , 우, 우하

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            if (pipe(i, 0)) ans++;
        }

        System.out.println(ans);
    }

    static boolean pipe(int y, int x) {
        if (x == c - 1) {
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            int nx = x + 1;

            if (ny < 0 || ny >= r || map[ny][nx] == 'x') continue;

            map[ny][nx] = 'x';
            if (pipe(ny, nx)) return true;
        }
        return false;
    }
}
