#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, cnt = 0;
    cin >> a >> b;
    if(a>b) swap(a, b);
    for(int i = a + 1; i < b; i++){
        cnt++;
        v.push_back(i);
    }
    cout << cnt << '\n';
    for(auto k : v){
        cout << k << ' ';
    }
}