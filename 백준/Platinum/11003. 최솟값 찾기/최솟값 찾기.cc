#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N,L;
    deque<pair<int, int>> dq;
    cin >> N >> L;
    for(int i = 0; i < N; i++){
        int a;
        cin >> a;

        while(!dq.empty() && dq.back().second >= a)
            dq.pop_back();

        dq.push_back({i,a});

        if(dq.front().first <= i-L){
            dq.pop_front();
        }
        cout << dq.front().second << '\n';
    }
    return 0;
}