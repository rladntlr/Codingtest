#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> date1, vector<int> date2) {
    string s1, s2;
    
    // 날짜를 문자열로 변환하여 비교
    for (int i = 0; i < date1.size(); i++) {
        s1 += to_string(date1[i]); 
        s2 += to_string(date2[i]);
    }
    
    // 문자열을 숫자로 변환하여 비교
    int i1 = stoi(s1);
    int i2 = stoi(s2);
    
    // 날짜 비교
    if (i1 >= i2)
        return 0;
    else
        return 1;
}
