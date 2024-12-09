#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    
    return (str1.find(str2) == string::npos) ? 2 : 1;
}