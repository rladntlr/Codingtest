#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<vector<int>> dots) {
    int answer = 0;
    sort(dots.begin(), dots.end());
    int side, height;
    side = dots[2][0] - dots[1][0];
    height = dots[1][1] - dots[0][1];
    answer = side * height;
    return answer;
}