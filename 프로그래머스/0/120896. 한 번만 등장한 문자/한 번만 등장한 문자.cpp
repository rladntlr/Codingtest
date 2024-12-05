#include <bits/stdc++.h>
using namespace std;

string solution(string s) {
    string answer = "";
    unordered_map<char, int> count;

    // 각 문자의 등장 횟수를 센다
    for (char c : s) {
        count[c]++;
    }

    // 등장 횟수가 1인 문자만 answer에 추가
    for (auto& [key, value] : count) {
        if (value == 1) {
            answer += key;
        }
    }

    // 사전 순으로 정렬
    sort(answer.begin(), answer.end());

    return answer;
}
