import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static Point company, home;
    static Point[] customers;
    static boolean[] visited;
    static int min;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 점 사이의 맨해튼 거리
    static int distance(Point a, Point b) {
        return Math.abs(a.x - b.x)
                + Math.abs(a.y - b.y);
    }

    static void dfs(int depth, Point current, int sum) {

        // 가지치기
        if(sum >= min) {
            return;
        }

        // 고객 N명을 모두 방문했다면
        if(depth == N) {

            // 마지막 고객 -> 집 거리 추가
            sum += distance(current, home);

            min = Math.min(min, sum);
            return;
        }

        // 다음에 방문할 고객 선택
        for(int i = 0; i < N; i++) {

            if(visited[i]) continue;

            visited[i] = true;

            dfs(
                depth + 1,
                customers[i],
                sum + distance(current, customers[i])
            );

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            // 회사
            company = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            // 집
            home = new Point(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            // 고객
            customers = new Point[N];

            for(int i = 0; i < N; i++) {
                customers[i] = new Point(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }

            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            // 회사에서 시작
            dfs(0, company, 0);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(min)
              .append("\n");
        }

        System.out.print(sb);
    }
}