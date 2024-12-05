#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> array) {
    vector<int> answer;
    int maxVal = 0, maxidx = 0;
    for(int i = 0; i < array.size(); i++){
        if(array[i]>maxVal){
            maxVal = array[i];
            maxidx = i;
        }
    }
    answer.push_back(maxVal);
    answer.push_back(maxidx);
    return answer;
}