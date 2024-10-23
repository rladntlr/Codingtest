#include <bits/stdc++.h>

using namespace std;

int solution(vector<string> order) {
    int answer = 0;
    for(int i = 0; i < order.size(); i++){
        if(order[i].find("ame")!=string::npos || order[i].find("any")!=string::npos){
            answer += 4500;
        }
        else answer +=5000;
    }
    return answer;
}