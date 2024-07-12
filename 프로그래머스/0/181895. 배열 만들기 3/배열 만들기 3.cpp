#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> answer;
    for(auto insert : intervals){
        for(int i = insert[0]; i <= insert[1]; i++) answer.push_back(arr[i]);
    }
    return answer;
}