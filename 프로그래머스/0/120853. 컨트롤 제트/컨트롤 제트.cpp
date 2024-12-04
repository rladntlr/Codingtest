#include <bits/stdc++.h>

using namespace std;

int solution(string s) {
    int answer = 0;
    stringstream ss(s);
    string str;
    vector<string> v;
    while(ss >> str) v.push_back(str);
    for(int i = 0; i < v.size(); i++){
        if(v[i] == "Z") answer-=stoi(v[i-1]);
        else answer += stoi(v[i]);
    }
    return answer;
}