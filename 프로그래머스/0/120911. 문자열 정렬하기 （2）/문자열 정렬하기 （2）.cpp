#include <bits/stdc++.h>
#include <vector>

using namespace std;

string solution(string my_string) {
    string answer = my_string;

    for (char &c : answer) {
        c = tolower(c);
    }

    sort(answer.begin(), answer.end());

    return answer;
}
