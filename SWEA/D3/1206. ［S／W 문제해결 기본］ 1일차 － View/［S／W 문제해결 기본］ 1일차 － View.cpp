#include <bits/stdc++.h>
 
using namespace std;
 
int building[1002];
int ans = 0, temp = 0;
 
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
 
    int t = 10;  // 테스트 케이스 수는 항상 10으로 주어짐
    for (int i = 1; i <= t; i++) {
        int n;
        cin >> n;
 
        // 건물 높이 입력
        for (int j = 0; j < n; j++) {
            cin >> building[j];
        }
 
        ans = 0;  // 각 테스트 케이스마다 초기화
 
        // 조망권 계산
        for (int k = 2; k < n - 2; k++) {
            temp = building[k] - max(max(building[k - 2], building[k - 1]), max(building[k + 1], building[k + 2]));
            if (temp > 0) {
                ans += temp;
            }
        }
 
        // 결과 출력
        cout << "#" << i << " " << ans << '\n';
    }
 
    return 0;
}