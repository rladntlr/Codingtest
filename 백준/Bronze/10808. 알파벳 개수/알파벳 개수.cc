#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;
    vector<int> v(26);

    for(auto c : s) v[c-'a']++;
    for(auto c : v) cout << c << ' ';
}
