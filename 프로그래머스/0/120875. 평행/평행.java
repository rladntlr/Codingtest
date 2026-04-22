import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        
        if (parallel(dots, 0, 1, 2, 3)) return 1;
        if (parallel(dots, 0, 2, 1, 3)) return 1;
        if (parallel(dots, 0, 3, 1, 2)) return 1;
        return 0;
    }

    boolean parallel(int[][] dots,int a, int b, int c, int d) {
        int x = (dots[a][0] - dots[b][0]) * (dots[c][1] - dots[d][1]);
        int y = (dots[a][1] - dots[b][1]) * (dots[c][0] - dots[d][0]);
        return x == y;
    }
}