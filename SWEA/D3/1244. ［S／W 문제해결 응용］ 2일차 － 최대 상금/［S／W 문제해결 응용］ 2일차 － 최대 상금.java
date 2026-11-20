import java.io.*;
import java.util.*;

public class Solution {

    static char arr[];
    static int cnt, max;
    static Set<Integer>[] visited;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = st.nextToken().toCharArray();
            cnt = Integer.parseInt(st.nextToken());

            max = 0;
            visited = new HashSet[cnt+1];

            for (int i = 0; i <= cnt; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(0);

            System.out.println("#" + tc + " " + max);
        }
    }

    static void dfs(int depth){
        int num = Integer.parseInt(new String(arr));
        if(!visited[depth].add(num)) return;
        if(depth == cnt){
            max = Math.max(max, num);
            return;
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                swap(i, j);
                dfs(depth+1);
                swap(i, j);
            }
        }
    }
    static void swap(int a, int b){
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }
}
