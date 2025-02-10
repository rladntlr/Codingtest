#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, ans = 0;
    string s;
    cin >> n;
    while(n--){
        cin >> s;
        stack<int> S;
        for(auto c : s){
            if(!S.empty() && S.top() == c) S.pop();
            else S.push(c);
        }
        if(S.empty()) ans++;
    }
    cout << ans << '\n';
}