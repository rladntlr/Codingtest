#include <bits/stdc++.h>

using namespace std;

int solution(string number) {
    int answer = 0;
    for(auto c : number){
        answer += c - '0';
        answer %= 9;
    }
    return answer;
}