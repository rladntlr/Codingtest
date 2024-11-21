#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int money) {
    vector<int> answer;
    int num1, num2;
    answer.push_back(money / 5500);
    answer.push_back(money % 5500);
    return answer;
}