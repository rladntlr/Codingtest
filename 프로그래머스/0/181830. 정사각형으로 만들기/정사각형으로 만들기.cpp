#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int maxx = max(arr.size(), arr[0].size());
    vector<vector<int>> answer(maxx, vector<int>(maxx,0));
    for(int i = 0; i < arr.size(); i++){
        for(int j = 0; j < arr[i].size(); j++){
            answer[i][j] = arr[i][j];
        }
    }
    return answer;
}