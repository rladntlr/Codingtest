#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for(auto c : strArr){
        if(c.find("ad")==string::npos) answer.push_back(c);
    }
    return answer;
}