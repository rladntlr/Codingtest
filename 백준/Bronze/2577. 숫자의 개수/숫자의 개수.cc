#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    cin >> a >> b >> c;
    int sum = a*b*c;
    vector<int> v(10);
    while(sum>0){
        v[sum%10]++;
        sum/=10;
    }
    for(auto c : v) cout << c << '\n';
}
