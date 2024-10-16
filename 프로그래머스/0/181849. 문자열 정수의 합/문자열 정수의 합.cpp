#include <string>
#include <vector>

using namespace std;

int solution(string num_str) {
    int answer = 0;
    for(int k : num_str)
        answer += k - '0';
    return answer;
}