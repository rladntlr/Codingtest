#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    for(auto& i : my_string){
        if(!isdigit(i))
            i = ' ';
            
    }
    stringstream ss(my_string);
    int k = 0;
    while(ss){
        answer += k;
        ss >> k;
    }
    return answer;
}