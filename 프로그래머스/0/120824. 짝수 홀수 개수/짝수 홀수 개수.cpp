#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    int isodd = 0, iseven = 0;
    for(auto c : num_list){
        if(c%2==0) iseven++;
        else isodd++;
    }
    answer.push_back(iseven);
    answer.push_back(isodd);
    return answer;
}