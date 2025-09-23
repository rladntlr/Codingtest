import java.util.*;

class Solution {

    static int[][] dp;

    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int size = info.length;

        // dp[i][j]: i번째 아이템까지 고려했을 때, j 상태에서의 최소 비용
        dp = new int[size + 1][m];

        // dp 테이블 초기화
        // i=0은 기본 상태로 두고, 나머지는 매우 큰 값으로 채워둠
        for(int i = 1; i <= size; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 아이템을 하나씩 고려
        for(int i = 1; i <= size; i++){
            for(int j = 0; j < m; j++){
                // A가 훔치면
                // 이전 상태 dp[i-1][j]에서 현재 아이템의 비용(info[i-1][0])을 더함
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + info[i - 1][0]);

                // B가 훔치면
                // 만약 j + info[i-1][1]이 m보다 작다면, 그 위치로 이동 가능
                // 이때는 비용 증가 없이, 이전 상태 dp[i-1][j] 그대로 옮겨옴
                if(j + info[i - 1][1] < m)
                    dp[i][j + info[i - 1][1]] = Math.min(dp[i - 1][j], dp[i][j + info[i - 1][1]]);
            }
        }

        // 모든 상태 중 최소 비용을 찾음
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            min = Math.min(min, dp[size][i]);
        }

        // 만약 최소 비용이 n 이상이라면 불가능하다는 의미로 -1 반환
        if(min >= n)
            min = -1;

        return min;
    }
}