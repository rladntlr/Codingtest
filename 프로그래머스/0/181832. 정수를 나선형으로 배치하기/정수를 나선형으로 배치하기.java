class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;
        int r = 0, c = 0;
        
        for(int i = 1; i <= n*n; i++){
            answer[r][c] = i;
            
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0){
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
}