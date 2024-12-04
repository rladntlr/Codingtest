#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<int> sides) {
    int answer = 0;
    sort(sides.begin(), sides.end());
    if(sides[0] + sides[1] > sides[2])
        return 1;
    else return 2;
}