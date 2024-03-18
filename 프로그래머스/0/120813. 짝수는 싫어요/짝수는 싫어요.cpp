#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n) {
    vector<int> odd;
    for(int i=1;i<=n;i++)
        if(i%2) odd.push_back(i);
    return odd;
}