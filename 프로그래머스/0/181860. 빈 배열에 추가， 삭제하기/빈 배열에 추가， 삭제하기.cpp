#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, vector<bool> flag) {
    vector<int> answer;
    for(int i = 0; i < arr.size(); i++){
        if(flag[i]==1){
            answer.insert(answer.end(),arr[i]*2,arr[i]);
        }
        else answer.erase(answer.end()-arr[i],answer.end());
    }
    return answer;
}