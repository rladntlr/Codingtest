#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> dot) {
    map<pair<int,int>, int> mp = {
        {{1,1},1},
        {{-1,1},2},
        {{-1,-1},3},
        {{1,-1},4}
    };
    int xsign = (dot[0] > 0) ? 1 : -1 ;
    int ysign = (dot[1] > 0) ? 1 : -1;
    
    return mp[{xsign, ysign}];
}