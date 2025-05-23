//
// Created by KIM on 2025-05-24.
//
#include "bits/stdc++.h"

using namespace std;

int a[102][102], visited[102][102];
int N, ans = 1;
int dy[4] = {-1, 0, 1, 0}, dx[4] = {0, 1, 0, -1};

void dfs(int y, int x, int d){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= N || nx >=N ) continue;
        if(visited[ny][nx] == 0 && a[ny][nx] > d) dfs(ny, nx, d);
    }
    return;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> a[i][j];
        }
    }

    for(int depth = 1; depth < 101; depth++){
        fill(&visited[0][0], &visited[0][0] + 102*102, 0);
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(a[i][j] > depth && visited[i][j] == 0){
                    dfs(i, j, depth);
                    cnt++;
                }
            }
        }
        ans = max(ans, cnt);
    }
    cout << ans << '\n';
    return 0;
}