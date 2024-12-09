#include <bits/stdc++.h>
#include <vector>

using namespace std;

vector<string> solution(vector<string> quiz) {
    vector<string> answer;
    for(auto s : quiz){
        stringstream ss(s);
        int a, b, c;
        char op, eq;
        ss >> a >> op >> b >> eq >> c;
        int cal = (op == '+') ? a + b : a - b;
        if(cal == c) answer.push_back("O");
        else answer.push_back("X");
    }
    return answer;
}