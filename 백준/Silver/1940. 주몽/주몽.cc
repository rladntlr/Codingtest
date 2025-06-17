////
//// Created by 김우식 on 25. 6. 17.
////
//#include <bits/stdc++.h>
//
//using namespace std;
//int a[15002];
//int main(){
//    int n, m, cnt = 0;
//    cin >> n >> m;
//    for(int i = 0; i < n; i++) cin >> a[i];
//    if(m > 20000) cout << 0 << '\n';
//    else{
//        for(int i = 0; i < n; i++){
//            for(int j = i + 1; j < n; j++)
//                if(a[i] + a[j] == m) cnt++;
//        }
//    }
//    cout << cnt << '\n';
//}
#include <bits/stdc++.h>
using namespace std;

bool occur[2000001];
int a[15002];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, cnt = 0;
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> a[i];

    for(int i = 0; i < n; i++) {
        // (m - a[i])가 배열에 있었으면 쌍이 만들어짐
        // a[i] == m - a[i] 인 케이스는 두 번 등장해야 쌍이 만들어지니 이 방식으로도 자동 처리됨
        if (m - a[i] > 0 && m - a[i] <= 2000000 && occur[m - a[i]]) {
            cnt++;
        }
        occur[a[i]] = true;
    }
    cout << cnt << '\n';
}
