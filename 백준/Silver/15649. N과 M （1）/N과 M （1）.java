import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] src, tgt;
    static boolean[] select;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        src = new int[n + 1];
        select = new boolean[n + 1];
        tgt = new int[m];

        for(int i = 1; i <= n; i++){
            src[i] = i;
        }

        perm(0);
    }

    static void perm(int tgtIdx) {
        if (tgtIdx == m ) {
            for (int n : tgt) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (select[i] == true) continue;
            tgt[tgtIdx] = src[i];
            select[i] = true;
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }
}
