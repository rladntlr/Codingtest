#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[1000002], b[1000002], c[2000004];

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int i = 0; i < n; i++)
        cin >> a[i];
    for(int i = 0; i < m; i++)
        cin >> b[i];

    int aindex = 0, bindex = 0;
    for(int i = 0; i < n+m; i++){
        if(bindex == m) c[i] = a[aindex++];
        else if(aindex == n) c[i] = b[bindex++];
        else if(a[aindex] >= b[bindex]) c[i] = b[bindex++];
        else c[i] = a[aindex++];
    }
    for(int i = 0; i < m+n; i++)
        cout << c[i] << ' ';
}