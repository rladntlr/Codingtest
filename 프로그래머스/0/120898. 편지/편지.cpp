#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(string message) {
    int answer = 0;
    int cnt = 0;
    for(auto c : message){
        cnt++;
    }
    return cnt*2;
}