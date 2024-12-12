#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<int> sides) {
    int answer = 0;
    if(sides[0] < sides[1])
        swap(sides[0], sides[1]);
    return sides[1] * 2 - 1;
}