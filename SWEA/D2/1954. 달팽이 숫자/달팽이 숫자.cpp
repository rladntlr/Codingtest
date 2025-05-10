#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T; 
    cin >> T;
    for(int tc = 1; tc <= T; ++tc){
        int n; 
        cin >> n;
        vector<vector<int>> a(n, vector<int>(n));

        int low = 0, col = -1;
        int size = n, dir = 1, val = 1;

        while(size > 0){
            for(int i = 0; i < size; ++i) 
                a[low][col += dir] = val++;
            --size;
            for(int i = 0; i < size; ++i) 
                a[low += dir][col] = val++;
            dir = -dir;
        }

        cout << "#" << tc << "\n";
        for(auto &row : a){
            for(int x : row) cout << x << " ";
            cout << "\n";
        }
    }
}
