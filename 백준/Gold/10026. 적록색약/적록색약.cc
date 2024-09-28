#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
char board[102][102];
int dist1[102][102];
int dist2[1002][1002];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n;
void bfs(int i, int j) {
    queue<pair<int, int>> Q;
    Q.push({i,j});
    dist1[i][j] = 1;
    while (!Q.empty()) {
        auto cur = Q.front();
        Q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(dist1[nx][ny] == 1 || board[i][j] != board[nx][ny]) continue;
            dist1[nx][ny] = 1;
            Q.push({nx,ny});
        }
    }
}

int area(){
    int cnt = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(dist1[i][j] == 0){
                cnt ++;
                bfs(i,j);
            }
        }
    }
    return cnt;
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }

    int not_g = area();

    for(int i = 0; i < n; i++){
        fill(dist1[i],dist1[i]+n,0);
    }

    for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] == 'G')
                board[i][j] = 'R';
        }
    }

    int is_g = area();

    cout << not_g << " " << is_g;
    return 0;
}