#include <bits/stdc++.h>
#include <vector>

using namespace std;

string solution(string polynomial) {
    string answer = "";
    stringstream ss(polynomial);
    int xnum = 0, num = 0;
    string s;

    while (ss >> s) {
        if (s == "+") continue; // '+'는 무시
        if (s.find("x") != string::npos) {
            if (s == "x") {
                xnum += 1; // 계수가 없는 'x'는 1로 처리
            } else {
                xnum += stoi(s.substr(0, s.find("x"))); // 'nx'에서 계수 추출
            }
        } else {
            num += stoi(s); // 상수항 처리
        }
    }

    // x 항 조합
    if (xnum != 0) {
        if (xnum == 1)
            answer += "x"; // 계수가 1이면 '1x' 대신 'x'
        else
            answer += to_string(xnum) + "x";
    }

    // 상수항 조합
    if (num != 0) {
        if (!answer.empty())
            answer += " + "; // x 항이 있을 경우 '+' 추가
        answer += to_string(num);
    }

    return answer.empty() ? "0" : answer; 
}
