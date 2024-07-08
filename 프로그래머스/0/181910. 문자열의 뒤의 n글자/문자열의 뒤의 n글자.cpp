#include <bits/stdc++.h>

using namespace std;

string solution(string my_string, int n) {
    string answer = "";
    int k = my_string.length() - n;
    for(int i = k; i < my_string.length(); i++){
        answer += my_string[i];
    }
    return answer;
}