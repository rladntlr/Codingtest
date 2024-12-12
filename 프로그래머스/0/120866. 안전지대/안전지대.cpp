#include <bits/stdc++.h>
#include <vector>

using namespace std;

// 8방향 이동을 위한 dx, dy 배열
int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
bool visited[102][102]; // 방문 체크 배열

int solution(vector<vector<int>> board) {
    int answer = 0;
    int n = board.size(); // 보드의 크기

    // 위험 지역 표시
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (board[i][j] == 1) { // 지뢰가 있는 경우
                visited[i][j] = true; // 현재 위치는 위험 지역
                for (int d = 0; d < 8; d++) { // 8방향 탐색
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) { // 경계 체크
                        visited[nx][ny] = true; // 위험 지역으로 표시
                    }
                }
            }
        }
    }

    // 안전 지역 개수 계산
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (!visited[i][j]) { // 방문하지 않은 지역은 안전 지역
                answer++;
            }
        }
    }

    return answer;
}
