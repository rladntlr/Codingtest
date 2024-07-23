#include <bits/stdc++.h>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    string s;
    for(auto c : my_string){
        if(c==' '){
            answer.push_back(s);
            s = "";
        }
        else{
            s += c;
        }
    }
    answer.push_back(s);
    return answer;
}