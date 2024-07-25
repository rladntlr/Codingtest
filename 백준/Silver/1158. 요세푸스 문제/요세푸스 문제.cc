#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,k;
    cin >> n >> k;
    list<int> l;
    for(int i = 1; i <= n; i++) l.push_back(i);
    auto cursor = l.begin();
    cout << '<';
    while(!l.empty()){
        for(int i = 1; i < k; i++){
            cursor++;
            if(cursor==l.end())cursor = l.begin();
        }
        if(l.size()==1) cout << *cursor;
        else cout << *cursor << ", ";
        cursor = l.erase(cursor);
        if (cursor == l.end() && !l.empty()) cursor = l.begin();
    }
    cout << ">";
}