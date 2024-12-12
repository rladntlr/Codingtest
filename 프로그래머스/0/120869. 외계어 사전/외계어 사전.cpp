#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    // spell을 정렬된 문자열로 변환
    sort(spell.begin(), spell.end());
    string target = "";
    for (const string& s : spell) {
        target += s;
    }

    // dic의 각 단어를 정렬된 문자열로 변환 후 비교
    for (string word : dic) {
        sort(word.begin(), word.end()); // 단어를 정렬
        if (word == target) {
            return 1; // spell과 동일한 조합이 존재
        }
    }

    return 2; // 존재하지 않음
}