#include<bits/stdc++.h>
using namespace std;

int n, t;
string a, b;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> t;
    while(t--){
        map<string, int> mp;
        cin >> n;
        for(int i = 0; i < n; i++){
            cin >> a >> b;
            mp[b]++;
        }
        long long ret = 1;
        for(auto c : mp) ret *= ((long long)c.second + 1); // int값들을 순회하면서 곱해
        ret--; // 마지막에 -1을 해주면 모두 안입은 경우를 뺄 수 있음
        cout << ret << "\n";
    }
    return 0;
}