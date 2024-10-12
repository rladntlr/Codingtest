#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    
    int i = 1;
    while(i < arr.size()){
        i *= 2;
    }
    vector<int> answer = arr;
    while(answer.size() < i)
        answer.push_back(0);
    return answer;
}