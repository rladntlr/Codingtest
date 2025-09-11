import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static char[][] map;
    static int n, cnt;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] != '1' || visited[i][j]) continue;

                cnt = 0;
                dfs(i, j);
                list.add(cnt);

            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list) System.out.println(i);
    }
    static void dfs(int y, int x) {
        visited[y][x] = true;

        cnt++;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if( ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] != '1' ||visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
