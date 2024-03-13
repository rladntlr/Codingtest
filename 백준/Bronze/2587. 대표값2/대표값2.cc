#include <bits/stdc++.h>
using namespace std;

int a[5];

int main() {
    for(int i = 0; i<5;i++){
        cin >> a[i];
    }
    sort(a,a+5);
    int c = a[2];
    int b = 0;
    for(int i = 0; i<5;i++){
         b += a[i];
    }
    cout << b/5 << '\n' << c;
}