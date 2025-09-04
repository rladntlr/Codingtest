import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] a = new int[2][7];
        int s, g;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            a[s][g]++;
        }

        for (int i = 0; i < 2; i++) {
            for(int j = 1; j < 7; j++) {
                ans += a[i][j]/k;
                if(a[i][j]%k != 0) ans++;
            }
        }
        System.out.println(ans);
    }
}