//
// Created by 김우식 on 25. 6. 8.
//
#include <bits/stdc++.h>

using namespace std;

int main(){
    string s, s1;
    cin >> s;
    s1 = s;
    reverse(s.begin(), s.end());

    if(s == s1) cout << 1 << '\n';
    else cout << 0 << '\n';

    return 0;
}