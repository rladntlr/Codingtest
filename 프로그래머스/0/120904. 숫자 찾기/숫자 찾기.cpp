#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(int num, int k) {
    int answer = 0;
    string s = to_string(num);
    char kk = to_string(k)[0];
    for(int i = 0; i < s.length(); i++){
        if(s[i] == kk){
            return i+1;
        }
            
    }
    return -1;
}