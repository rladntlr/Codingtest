#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<int> array) {
    int answer = 0;
    for(auto i : array){
        while(1){
            if(i % 10 == 0) break;
            if(i % 10 == 7) answer++;
            i/=10;
        }
    }
    return answer;
}