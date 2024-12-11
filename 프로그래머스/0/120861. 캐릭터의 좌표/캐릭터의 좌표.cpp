#include <bits/stdc++.h>
#include <vector>
#include <string>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer = {0, 0};
    
    int height_max = board[1] / 2;
    int height_min = -board[1] / 2;
    int left_max = -board[0] / 2;
    int right_max = board[0] / 2;
    
    for (const auto& s : keyinput) {
        if (s == "left") {
            if (left_max < answer[0])
                answer[0]--;
        } else if (s == "right") {
            if (right_max > answer[0])
                answer[0]++;
        } else if (s == "up") {
            if (height_max > answer[1])
                answer[1]++;
        } else if (s == "down") {
            if (height_min < answer[1])
                answer[1]--;
        }
    }
    
    return answer;
}
