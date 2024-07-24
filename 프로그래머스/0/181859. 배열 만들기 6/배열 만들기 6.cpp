#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int i = 0;
    while(i<arr.size()){
        if(answer.empty()){
            answer.push_back(arr[i]);
            i++;
        }
        else if(!answer.empty() && answer[answer.size() - 1] == arr[i]) {
            answer.pop_back();
            i++;
        }
        else if(!answer.empty() && answer[answer.size() - 1] != arr[i]) {
            answer.push_back(arr[i]);
            i++;
        }
    }
    if(answer.empty()) answer.push_back(-1);

    return answer;
}