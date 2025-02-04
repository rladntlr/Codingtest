#include <bits/stdc++.h>
using namespace std;

int cnt[103];
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    string str;
    cin >> str;
    string rev = str;
    reverse(rev.begin(), rev.end());

    if(rev == str) cout << 1;
    else cout << 0;

    return 0;
}