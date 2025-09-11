
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀 호출
public class Main {
    static int tc,n,m;
    static int[][] memoi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            memoi = new int[m + 1][n + 1];

            System.out.println(combi(m,n));


        }

    }
    // nCr
    static int combi(int n, int r) {
        if (n == r || r == 0)
            return memoi[n][r] = 1;
        if (memoi[n][r] > 0) {
            return memoi[n][r];
        }
        return memoi[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

}
