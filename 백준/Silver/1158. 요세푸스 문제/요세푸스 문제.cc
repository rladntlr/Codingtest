#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n,k;
    cin >> n >> k;
    list<int> N={};
    for(int i = 1; i <= n;i++)
        N.push_back(i);
    auto cursor = N.begin();

    cout << '<';
    while (!N.empty()) {
        for (int i = 1; i < k; i++) {
            cursor++;
            if (cursor == N.end()) {
                cursor = N.begin();
            }
        }
        if(N.size()==1) cout << *cursor;
        else cout << *cursor << ", ";
        cursor = N.erase(cursor);
        if (cursor == N.end()) {
            cursor = N.begin();
        }
    }
    cout << '>';
}
