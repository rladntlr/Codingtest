#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int testcase;
    cin >> testcase;
    for(int i=0;i<testcase;i++){
        list<char> N ={};
        string n;
        auto cursor = N.begin();
        cin >> n;

        for(auto c : n){
            if(c=='<'){
                if(cursor!=N.begin()) cursor--;
            }
            else if(c=='>'){
                if(cursor!=N.end()) cursor++;
            }
            else if(c=='-'){
                if(cursor!=N.begin()){
                    cursor--;
                    cursor=N.erase(cursor);
                }
            }
            else N.insert(cursor,c);
        }
        for(auto c:N) cout << c;
        cout << '\n';
    }
}