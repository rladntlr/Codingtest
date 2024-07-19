#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, string alp) {
    string answer = "";
    for(auto &c : my_string){
        if(c==alp[0]) c = toupper(c);
    }
    return my_string;
}