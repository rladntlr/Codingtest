#include <bits/stdc++.h>
using namespace std;

int main(){
    string s;
    cin >> s;
    vector<int> word(26,0);
    for(auto num:s){
        word[num-'a']++;
    }
    for(int i=0;i<word.size();i++)
        cout << word[i] << ' ';
}