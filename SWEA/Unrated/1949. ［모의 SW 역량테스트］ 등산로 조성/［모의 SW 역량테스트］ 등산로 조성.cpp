#include <bits/stdc++.h>
using namespace std;

int N, K;
int board[8][8];           
bool visited[8][8];     
int max_height;          
int answer;               
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};


void dfs(int x, int y, int len, bool used) {

    answer = max(answer, len);

    for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];


        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (visited[nx][ny]) continue;


        if (board[nx][ny] < board[x][y]) {
            visited[nx][ny] = true;
            dfs(nx, ny, len + 1, used);
            visited[nx][ny] = false;
        }

        else if (!used && board[nx][ny] - K < board[x][y]) {
            int original = board[nx][ny]; 
            board[nx][ny] = board[x][y] - 1;
            visited[nx][ny] = true;
            dfs(nx, ny, len + 1, true);
            visited[nx][ny] = false;
            board[nx][ny] = original; 
        }
    }
}

int main() {
    int T;
    cin >> T;

    for (int test = 1; test <= T; test++) {
        cin >> N >> K;
        max_height = 0;
        answer = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cin >> board[i][j];
                max_height = max(max_height, board[i][j]);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == max_height) {
                    visited[i][j] = true;
                    dfs(i, j, 1, false); 
                    visited[i][j] = false;
                }
            }
        }

        cout << "#" << test << " " << answer << '\n';
    }
}
