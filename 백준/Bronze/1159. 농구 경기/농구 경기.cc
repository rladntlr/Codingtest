//
// Created by 김우식 on 25. 6. 9.
//
#include <bits/stdc++.h>

using namespace std;
int lastname[26], n;
string s, ans;
int main(){
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> s;
        lastname[s[0] - 'a']++;
    }
    for(int i = 0 ; i < 26; i++){
        if(lastname[i] >= 5)
            ans += i + 'a';
    }
    if(ans.size()) cout << ans << '\n';
    else cout << "PREDAJA";
}