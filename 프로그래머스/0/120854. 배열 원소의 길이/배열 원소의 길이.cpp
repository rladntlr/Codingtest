#include <bits/stdc++.h>
#include <vector>

using namespace std;

vector<int> solution(vector<string> strlist) {
    vector<int> answer;
    for(auto s : strlist){
        int a = 0;
        for(int i = 0; i < s.size(); i++){
            a++;
        }
        answer.push_back(a);
    }
    return answer;
}