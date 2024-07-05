#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    for(auto c : intStrs){
        int new_num = stoi(c.substr(s,l));
        if(new_num > k) answer.push_back(new_num);
    }
    return answer;
}