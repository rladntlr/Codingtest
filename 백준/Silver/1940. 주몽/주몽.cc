#include <bits/stdc++.h>
using namespace std;

int cnt[15005];
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, ans = 0;
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> cnt[i];
    if(m > 200000) cout << 0;
    else{
        for(int i = 0 ; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(cnt[i] + cnt[j] == m) ans++;
            }
        }
        cout << ans;
    }
}