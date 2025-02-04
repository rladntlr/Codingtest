#include <bits/stdc++.h>
using namespace std;

int cnt[26];
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    string s;

    getline(cin, s);

    for(int i = 0; i < s.size(); i++){
        if(s[i] >= 65 && s[i] < 91){ // 대문자
            if(s[i] + 13 > 90) s[i] = s[i] - 13;
            else s[i] = s[i] + 13;
        }
        else if(s[i] >= 97 && s[i] <= 122){ // 소문자
            if(s[i] + 13 > 122) s[i] = s[i] - 13;
            else s[i] = s[i] + 13;
        }
        cout << s[i];
    }
    return 0;
}