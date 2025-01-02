#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int sum = 0;
    for (int i = 0; i < 7; i++) {
        int x;
        cin >> x;
        if (x % 2 != 0) { // 홀수만 처리
            sum += x;
            v.push_back(x);
        }
    }

    if (v.empty()) { // 홀수가 없는 경우 처리
        cout << -1;
    } else {
        sort(v.begin(), v.end());
        cout << sum << '\n' << v[0];
    }

    return 0;
}
