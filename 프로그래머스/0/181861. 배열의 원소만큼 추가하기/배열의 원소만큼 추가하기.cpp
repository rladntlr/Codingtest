#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    for(auto c : arr){
        for(int i = 0; i < c; i++){
            answer.push_back(c);
        }
    }
    return answer;
}