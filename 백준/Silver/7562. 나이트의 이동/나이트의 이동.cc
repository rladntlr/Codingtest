#include <bits/stdc++.h>
using namespace std;
int board[304][304];
int dist1[304][304];
int dx[8] = {-2,-1,1,2, 2, 1, -1, -2};
int dy[8] = {1,2,2,1,-1,-2,-2,-1};
int T, I, now_x, now_y, go_x, go_y;
queue<pair<int,int>> Q;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T--){
        cin >> I;
        for(int i = 0; i < I; i++) fill(dist1[i], dist1[i]+I,-1);
        cin >> now_x >> now_y;
        dist1[now_x][now_y] = 0;
        Q.push({now_x,now_y});
        cin >> go_x >> go_y;
        while(!Q.empty()){
            auto cur = Q.front();
            Q.pop();
            for(int dir = 0; dir < 8; dir++){
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir];
                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                if(dist1[nx][ny] >=0 ) continue;
                dist1[nx][ny] = dist1[cur.first][cur.second] + 1;
                Q.push({nx, ny});
            }
        }
        cout << dist1[go_x][go_y] << '\n';
    }
}
