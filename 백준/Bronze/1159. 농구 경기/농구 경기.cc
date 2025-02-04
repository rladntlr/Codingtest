#include <bits/stdc++.h>
using namespace std;

int cnt[26];
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    int num;
    string name, entry;

    cin >> num;

    for(int i = 0 ; i < num ; i++){
        cin >> name;
        cnt[name[0] - 'a']++;
    }
    for(int i = 0; i < 26; i++) if(cnt[i] >= 5) entry += i + 'a';
    if(entry.size()) cout << entry;
    else cout << "PREDAJA";

    return 0;
}