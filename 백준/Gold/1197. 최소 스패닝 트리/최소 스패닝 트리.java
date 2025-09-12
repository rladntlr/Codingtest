import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// MST
// 간선 리스트의 모든 간선을 비용 기준으로 정렬 ( 오름 차순 )
// 가장 비용이 적은 간선부터 차례대로 선택해 간다.
// 간선 선택 시 사이클이 발생 X <= Union Find 알고리즘 이용
// 간선 중심 풀이
public class Main {

    static int v, e;
    static long sum;
    static List<List<Vertex>> adjList = new ArrayList<>();
    static boolean[] visited;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Vertex>());
        }

        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(v1).add(new Vertex(v2, c));
            adjList.get(v2).add(new Vertex(v1, c));
        }
        pq.offer(new Vertex(1, 0));
        int cnt = 0;

        while (!pq.isEmpty()) {
            Vertex vertex = pq.poll();
            if (visited[vertex.v]) continue;

            // 왜 while 문 전에 안넣을까??
            visited[vertex.v] = true;
            sum += vertex.c;
            cnt++;

            if (cnt == v) break;

            for (Vertex v : adjList.get(vertex.v)) {
                if (visited[v.v]) continue;
                pq.offer(new Vertex(v.v, v.c));
            }
        }
        System.out.println(sum);
    }
    static class Vertex{
        int v, c;

        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}