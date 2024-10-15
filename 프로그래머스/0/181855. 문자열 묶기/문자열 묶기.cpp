#include <bits/stdc++.h>

using namespace std;
vector<int> v(31,0);
int solution(vector<string> strArr) {
    int answer = 0;
    for(int i  = 0; i<strArr.size(); i++){
        v[strArr[i].size()]++;
        answer = max(answer, v[strArr[i].size()]);
    }
    return answer;
}