#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    for(auto c : num_list){
        while(c!=1){
            if(c%2==0) c/=2;
            else c = (c - 1) / 2;
            answer++;
        }
    }
    return answer;
}