#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int sum = 0, av = 0;
    for(int i = 0; i < 5; i++){
        int x;
        cin >> x;
        v.push_back(x);
        sum += x;
        av = sum/5;
    }
    sort(v.begin(), v.end());
    cout << av << '\n' << v[2];
}