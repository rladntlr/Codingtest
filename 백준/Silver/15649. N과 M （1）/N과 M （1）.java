
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] tgt;
    static boolean[] select;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        select = new boolean[n + 1];
        tgt = new int[m];

        sb = new StringBuilder();

        perm(0);
        System.out.println(sb);
    }

    static void perm(int tgtIdx) {
        if (tgtIdx == m ) {
            for (int n : tgt) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (select[i] == true) continue;
            tgt[tgtIdx] = i;
            select[i] = true;
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }
}
