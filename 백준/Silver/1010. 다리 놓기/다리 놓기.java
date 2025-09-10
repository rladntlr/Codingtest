
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int tc,n,m,ans;
    static int[][] memoi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            memoi = new int[m + 1][m + 1];
            memoi[0][0] = 1;

            for(int i = 1; i <= m; i++){
                for(int j = 0; j <= i; j++){
                    if(j == 0 || j == i) {
                        memoi[i][j] = 1;
                        continue;
                    }
                    memoi[i][j] = memoi[i-1][j-1] + memoi[i-1][j];
                }
            }
            System.out.println(memoi[m][n]);

        }

    }

}
