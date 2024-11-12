#include <bits/stdc++.h>
using namespace std;

string st;
vector<string> v;

bool cmp(const string& a, const string& b){
    int asize = a.size(), bsize = b.size();
    int suma = 0, sumb = 0;
    if(asize != bsize) return asize < bsize;

    for(int i = 0; i < a.size(); i++){
        if(isdigit(a[i])) suma += (a[i] - '0');
    }
    for(int i = 0; i < b.size(); i++){
        if(isdigit(b[i])) sumb += (b[i] - '0');
    }
    if(suma != sumb) return suma < sumb;
    return a < b;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> st;
        v.push_back(st);
    }
    sort(v.begin(), v.end(), cmp);
    for(auto i : v) cout << i << '\n';
}