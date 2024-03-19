#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string n;
    cin >> n;
    list<char> N;
    for(auto c: n) N.push_back(c);
    auto cursor = N.end();

    int M;
    cin >> M;
    while(M--){
        char op;
        cin >> op;
        if(op=='L'){
            if(cursor!=N.begin()) cursor--;
        }
        else if(op=='D'){
            if(cursor!=N.end()) cursor++;
        }
        else if(op=='B'){
            if(cursor!=N.begin()){
                cursor--;
                cursor = N.erase(cursor);
            }
        }
        else{
            char add;
            cin >> add;
            N.insert(cursor,add);
        }
    }
    for(auto c: N) cout << c;
}