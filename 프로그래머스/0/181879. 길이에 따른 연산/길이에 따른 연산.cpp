#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    while(1){
        if(num_list.size()>10){
            for(auto c : num_list) answer += c; return answer;
        }
        else{
            answer = 1;
            for(auto c: num_list){
                answer *= c;
            }
            return answer;
        }
    }
}