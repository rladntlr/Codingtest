#include <bits/stdc++.h>
using namespace std;

int main() {
    int T;
    cin >> T;
    
    while (T--) {
        int a, b, n;
        cin >> a >> b >> n;
        int cnt = 0;
        
        while (a <= n && b <= n) {
            if (a > b)
                b += a;
            else
                a += b;
            cnt++;
        }
        
        cout << cnt << '\n';
    }
    
    return 0; // 정상 종료
}