#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> picture, int k) {
    vector<string> answer;
    for(int i = 0; i < picture.size(); i++){
        string add;
        for(int j = 0; j < picture[i].size(); j++){
            for(int m = 0; m < k; m++){
                add += picture[i][j];
            }
        }
        for(int j = 0; j < k; j++){
            answer.push_back(add);
        }
    }
    return answer;
}