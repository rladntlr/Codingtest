
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST
// 시작 정점에서부터 가장 비용이 적은 다른 정점을 계속 선택해 간다.
// 이 때 선택의 대상은 이미 선택된 모든 정점으로부터 갈 수 있는 선택되지 않은 정점
// 가장 비용이 적은 다른 정점을 선택 <= PriorityQueue 를 이용
// 정점 중심 풀이
public class Main {

    static int v, e;
    static long sum;
    static Edge[] edges;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new Edge[e];
        parent = new int[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v1, v2, c);
        }
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
        makeSet();

        int cnt = 0;

        for (int i = 0; i < e; i++) {
            Edge edge = edges[i];
            // 사이클 검사
            if(union(edge.v1, edge.v2)) {
                sum += edge.c;
                cnt++;
                if (cnt == v-1) break;
            }
        }
        System.out.println(sum);
    }

    static class Edge {
        int v1, v2, c;

        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }

    static void makeSet() {
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
    }

    // Path Compression 버전
    static int findSet(int x) {
        // x의 대표원소, 최상위 부모를 찾아 리턴
        if( parent[x] == x ) return x;
        return parent[x] = findSet(parent[x]);
    }

    // x 원소가 속한 집합과 y 원소가 속한 집합을 합집합으로
    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if(px == py) return false;
        if( px < py ) parent[py] = px;
        else parent[px] = py; // px == py 포함
        return true;
    }
}