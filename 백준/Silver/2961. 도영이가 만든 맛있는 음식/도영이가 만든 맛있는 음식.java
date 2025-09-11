
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, min;
    static int[][] src;
    static boolean[] select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        select = new boolean[n];
        src = new int[n][2];

        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }
        subset(0);

        System.out.println(min);
    }
    static void subset(int srtidx) {
        if(srtidx == src.length){
            int sin = 1;
            int ssn = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(select[i]){
                    sin *= src[i][0];
                    ssn += src[i][1];
                    cnt++;
                }
            }
            if(cnt > 0){
                min = Math.min(min, Math.abs(sin - ssn));
            }
            return;
        }
        select[srtidx] = true;
        subset(srtidx + 1);

        select[srtidx] = false;
        subset(srtidx + 1);
    }
}
