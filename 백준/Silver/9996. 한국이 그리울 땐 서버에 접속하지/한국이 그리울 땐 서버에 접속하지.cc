#include <bits/stdc++.h>
using namespace std;

int cnt[26];
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    int n;
    string s, pre, suf, dir;
    cin >> n >> s;

    int pos = s.find('*');
    pre = s.substr(0,pos);
    suf = s.substr(pos + 1);
    for(int i = 0; i < n; i++){
        cin >> dir;
        if(pre.size() + suf.size() > dir.size()) cout << "NE\n";
        else{
            if(pre == dir.substr(0,pre.size()) && suf == dir.substr(dir.size() - suf.size())) cout << "DA\n";
            else cout << "NE\n";
        }
    }
    return 0;
}
