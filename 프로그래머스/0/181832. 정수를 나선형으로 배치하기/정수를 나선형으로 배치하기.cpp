#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer(n, vector<int>(n, 0)); 
    int dx[4] = {0, 1, 0, -1};  // 우, 하, 좌, 상 (x 축 이동)
    int dy[4] = {1, 0, -1, 0};  // 우, 하, 좌, 상 (y 축 이동)
    
    int x = 0, y = 0;  // 시작 위치
    int dir = 0;  // 0: 우, 1: 하, 2: 좌, 3: 상
    int num = 1;  // 채울 숫자

    for (int i = 0; i < n * n; i++) {
        answer[x][y] = num++;  // 현재 위치에 숫자 채우기
        
        // 다음 위치로 이동
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        // 경계를 넘거나 이미 숫자가 채워져 있는 경우, 방향을 바꿈
        if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
            dir = (dir + 1) % 4;  // 방향을 전환 (우 -> 하 -> 좌 -> 상)
            nx = x + dx[dir];
            ny = y + dy[dir];
        }
        
        // 위치 업데이트
        x = nx;
        y = ny;
    }
    
    return answer;
}