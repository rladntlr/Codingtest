import java.io.*;
import java.util.*;

public class Solution {
    static int N, max, min;
    static int[] op, num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            op = new int[4];
            num= new int[N];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++){
                op[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, num[0]);
            System.out.println("#" + tc + " " + (max - min));
        }
    }
    static void dfs(int idx, int val){
        if(idx==N){
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(op[i] == 0) continue;
            op[i]--;
            dfs(idx + 1, calc(val, num[idx], i));
            op[i]++;
        }
    }

    static int calc(int val, int number, int i){
        switch (i){
            case 0 : return val + number;
            case 1 : return val - number;
            case 2 : return val * number;

        }
        return val / number;
    }
}
