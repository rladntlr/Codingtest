#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> numbers, int n) {
    int answer = 0;
    for(auto c : numbers){
        answer += c;
        if(answer > n) return answer;
    }
}