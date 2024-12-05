#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    stringstream ss(my_string);
    ss >> answer;
    
    int n;
    char c;
    while(ss >> c >> n){
        if(c == '+') answer+=n;
        else answer -= n;
    }
    
    return answer;
}