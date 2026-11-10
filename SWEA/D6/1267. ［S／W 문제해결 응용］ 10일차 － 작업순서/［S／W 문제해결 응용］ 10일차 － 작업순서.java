import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[V+1];
            for(int i = 1; i <= V; i++){
                list[i] = new ArrayList<>();
            }
            int[] indegree = new int[V+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                indegree[b]++;
            }

            Deque<Integer> q = new ArrayDeque<>();

            for(int i = 1; i <= V; i++){
                if(indegree[i] == 0){
                    q.addLast(i);
                }
            }
            sb.append("#").append(tc);
            while (!q.isEmpty()) {
                int cur = q.poll();
                sb.append(" ").append(cur);

                for (int next : list[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) q.addLast(next);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
