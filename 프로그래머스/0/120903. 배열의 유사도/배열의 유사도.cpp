#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<string> s1, vector<string> s2) {
    int answer = 0;
    for(auto s : s1){
        for(auto ss : s2){
            if(s == ss)
                answer++;
        }
    }
    return answer;
}