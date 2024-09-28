#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[52][52];
int dist1[52][52];
int dist2[1002][1002];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
queue<pair<int, int>> Q;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int m, n, k, t;
    cin >> t;
    while(t--){
        cin >> m >> n >> k;
        int x, y;
        for(int i = 0; i < k; i++){
            cin >> x >> y;
            board[x][y] = 1;
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 && dist1[i][j]== 0){
                    dist1[i][j] = 1;
                    Q.push({i,j});
                    while (!Q.empty()){
                        auto cur = Q.front();
                        Q.pop();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur.X + dx[dir];
                            int ny = cur.Y + dy[dir];
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if(dist1[nx][ny] == 1 || board[nx][ny] == 0 ) continue;
                            dist1[nx][ny] = 1;
                            Q.push({nx,ny});
                        }
                    }
                    ans++;
                }
            }
        }
        cout << ans << '\n';
        for(int i = 0; i < m; i++){
            fill(board[i], board[i]+n, 0);
            fill(dist1[i], dist1[i]+n, 0);
        }
    }
    return 0;
}