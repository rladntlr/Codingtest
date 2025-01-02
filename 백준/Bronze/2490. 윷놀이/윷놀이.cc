#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 3; i++) {
        int sum = 0;
        for (int j = 0; j < 4; j++) {
            int x;
            cin >> x;
            sum += x;
        }

        // 결과 출력
        if (sum == 4) cout << 'E' << '\n';
        else if (sum == 3) cout << 'A' << '\n';
        else if (sum == 2) cout << 'B' << '\n';
        else if (sum == 1) cout << 'C' << '\n';
        else cout << 'D' << '\n';
    }
    return 0;
}