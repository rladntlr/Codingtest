#include <bits/stdc++.h>
using namespace std;

int n;
int T[16], P[16];
int dp[16];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> T[i] >> P[i];
    }

    // 동적 계획법을 이용한 최대 수익 계산
    for (int i = 1; i <= n; i++) {
        // 현재까지의 최대 수익을 다음 날로 이어서 갱신
        dp[i] = max(dp[i], dp[i - 1]);

        // 상담을 진행할 수 있는 경우, 상담이 끝나는 날 이후로 최대 수익 갱신
        if (i + T[i] - 1 <= n) {
            dp[i + T[i] - 1] = max(dp[i + T[i] - 1], dp[i - 1] + P[i]);
        }
    }

    // 최종적으로 최대 수익을 출력
    cout << *max_element(dp + 1, dp + n + 1) << '\n';
    return 0;
}
