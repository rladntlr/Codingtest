#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    stack<int> a;
    while(n--){
        string s;
        cin >> s;
        if(s=="push"){
            int X;
            cin >> X;
            a.push(X);
        }
        else if(s=="pop"){
            if(a.empty()) cout << -1 << '\n';
            else{
                cout << a.top() << '\n';
                a.pop();
            }
        }
        else if(s=="size") cout << a.size() << '\n';
        else if(s=="empty") cout << a.empty() << '\n';
        else{
            if(a.empty()) cout << -1 << '\n';
            else cout << a.top() << '\n';
        }
    }
}
