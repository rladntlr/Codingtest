#include <bits/stdc++.h>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    string s = "";
    for(int i = 0; i < my_string.length(); i++){
        if(my_string[i] != ' ') s += my_string[i];
        else if(s!=""){
            answer.push_back(s);
            s = "";
        }
    }
    if(s!="") answer.push_back(s);
    return answer;
}