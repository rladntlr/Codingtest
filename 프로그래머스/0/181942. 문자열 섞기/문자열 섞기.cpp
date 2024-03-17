#include <bits/stdc++.h>

using namespace std;

string solution(string str1, string str2) {
    string ans;
    for(int i = 0; i<str1.size(); i++){
        ans +=str1[i];
        ans +=str2[i];
    }
    return ans;
}