class Solution {
    public int solution(int n, int w, int num) {
        // 창고를 2차원 배열로 시뮬레이션
        int[][] warehouse = new int[101][101]; // 제한 조건 n ≤ 100이므로 넉넉히
        int box = 1; // 현재 놓을 박스 번호
        int h = 0;   // 현재 층 (행)
        boolean leftToRight = true; // 방향

        // 상자를 채우기
        while (box <= n) {
            if (leftToRight) { // 왼쪽 -> 오른쪽
                for (int i = 0; i < w && box <= n; i++) {
                    warehouse[h][i] = box++;
                }
            } else { // 오른쪽 -> 왼쪽
                for (int i = w - 1; i >= 0 && box <= n; i--) {
                    warehouse[h][i] = box++;
                }
            }
            h++;
            leftToRight = !leftToRight; // 방향 전환
        }

        // num의 위치 찾기
        int targetRow = -1, targetCol = -1;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (warehouse[row][col] == num) {
                    targetRow = row;
                    targetCol = col;
                    break;
                }
            }
            if (targetRow != -1) break;
        }

        // 위에 쌓인 박스 개수 세기
        int count = 0;
        for (int row = targetRow; row < h; row++) {
            if (warehouse[row][targetCol] != 0) count++;
        }

        return count;
    }
}