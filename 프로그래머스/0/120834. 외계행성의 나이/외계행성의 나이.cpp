#include <bits/stdc++.h>

using namespace std;

string solution(int age) {
    string answer = "";
    answer = to_string(age);
    for(auto &s : answer){
        s += 'a' - '0';
    }
    return answer;
}