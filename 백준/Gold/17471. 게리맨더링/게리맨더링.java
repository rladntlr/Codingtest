
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
// 부분집합
//   선택된, 선택되지 않은 두 개의 선거구로 표현
// 두 선거구 모두 선택된 각 구역별로 모두 연결?? 
//   bfs, dfs
// 각 구역별 연결 여부 확인 - 인접 행렬
// dfs
public class Main {
    static int N, min;
    static boolean[][] matrix; // 가중치가 없는 그래프 연결 
    static int[] population; // 각 구역별 인구수 관리
    static boolean[] select; // 부분집합에서 사용
    static boolean[] visit; // 완탐 재 방문 방지 + 모두 연결되었는지에도 사용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new boolean[N + 1][N + 1];
        population = new int[N + 1];

        select = new boolean[N + 1];
        visit = new boolean[N + 1];

        // 인구수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        // 구역별 연결 - matrix
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // i 구역에 연결되어 있는 구역 수
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());  // i -> v 연결
                matrix[i][v] = true;
            }
        }

        // 풀이
        min = Integer.MAX_VALUE;

        subset(1); // 1 구역시작

        if( min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    // sel : A 그룹 (true), B 그룹 (false)
    static void dfs(int v, boolean sel) {
        visit[v] = true;
        for (int i = 1; i <= N; i++) {
            if( ! matrix[v][i] || visit[i] || select[i] != sel ) continue;
            dfs(i, sel);
        }
    }
    // select 배열이 완성(선택,비선택)
    // A, B 두 개로 나누어서 각각 모두 연결되었는지 확인 - bfs
    // 인구수 계산 후 최소값 갱신
    static void check() {

        // visit 배열, queue 초기화
        Arrays.fill(visit, false);

        // A (select)
        int a = -1;
        for (int i = 1; i <= N; i++) {
            if( select[i] ) {
                a = i;
                break; // A 선거구에 해당하는 구역 1개만 선택하고 break
            }
        }

        if( a == -1 ) return;
        dfs( a, true );


        // B (not select)
        int b = -1;
        for (int i = 1; i <= N; i++) {
            if( ! select[i] ) {
                b = i;
                break; // B 선거구에 해당하는 구역 1개만 선택하고 break
            }
        }

        if( b == -1 ) return;
        dfs( b, false );

        // 모두 연결되어 있는지 확인
        // visit 배열
        for (int i = 1; i <= N; i++) {
            if( ! visit[i] ) return; // 방문하지 않은 구역이 있으면 return
        }

        // 정상적인 두 선거구 분리
        // A, B 선거구 각각 인구수의 합 -> 차
        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i <= N; i++) {
            if( select[i] ) sumA += population[i];
            else sumB += population[i];
        }

        min = Math.min(min, Math.abs(sumA - sumB));
    }

    // 부분집합
    static void subset(int srcIdx) {
        // 기저 조건
        if( srcIdx == N + 1 ) {
            // 부분집합 완성
            // select 배열에 선택, 비선택이 표현
            check();
            return;
        }

        select[srcIdx] = true;
        subset(srcIdx + 1);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }
}
