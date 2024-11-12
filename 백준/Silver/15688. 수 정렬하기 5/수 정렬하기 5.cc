#include <bits/stdc++.h>
using namespace std;

int a[1000002], b[1000002], c[2000004];

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        int a;
        cin >> a;
        c[a+1000000]++;
    }
    for(int i = 0; i <= 2000000; i++){
        while(c[i]--){
            cout << i-1000000 << '\n';
        }
    }
}