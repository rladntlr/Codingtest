#include <bits/stdc++.h>

using namespace std;

string solution(string rsp) {
    string answer = "";
    for(auto s : rsp){
        if(s == '2') answer+='0';
        else if(s == '0') answer +='5';
        else answer += '2';
    }
    return answer;
}