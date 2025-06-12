//
// Created by 김우식 on 25. 6. 10.
//
#include <bits/stdc++.h>

using namespace std;
int t, n;
string s1, s2;
int main(){
    cin >> t;
    while(t--){
        map<string, int> mp;
        cin >> n;
        for(int i = 0; i < n; i++){
            cin >> s1 >> s2;
            mp[s2]++;
        }
        long long ans = 1;
        for(auto i : mp)
            ans *= ((long long)i.second + 1);
        ans--;
        cout << ans << "\n";
    }
    return 0;
}