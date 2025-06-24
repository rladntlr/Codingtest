//
// Created by 김우식 on 25. 6. 24.
//
#include <bits/stdc++.h>

using namespace std;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, -1, 0, 1};
int a[104][104], visited[104][104], m, n, k, y_second, y_first, x_first, x_second;
vector<int> ans;
int dfs(int y, int x){
    visited[y][x] = 1;
    int ans = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[ny][nx] == 1) continue;
        if(a[ny][nx] == 1) continue;
        ans += dfs(ny, nx);
    }
    return ans;
}
int main(){
    cin >> m >> n >> k;
    for(int i = 0; i < k; i++){
        cin >> x_first >> y_first >> x_second >> y_second;
        for(int x = x_first; x < x_second; x++){
            for(int y = y_first; y < y_second; y++){
                a[y][x] = 1;
            }
        }
    }
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(a[i][j] != 1 && visited[i][j] == 0)
                ans.push_back(dfs(i, j));
        }
    }
    sort(ans.begin(), ans.end());
    cout << ans.size() << '\n';
    for(int i : ans) cout << i << '\n';
    return 0;
}