#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, x, ans = 0;
    vector<int> num(100005, 0);
    vector<bool> check(2000005, 0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> num[i];
    }
    cin >> x;
    for (int i = 0; i < n; i++) {
        if (x - num[i] > 0 && check[x - num[i]]) ans++;
        check[num[i]] = true;
    }
    cout << ans;
}