#include <string>
#include <vector>

using namespace std;

string solution(string n_str) {
    string answer = "";
    int n;
    for(int i = 0; i < n_str.length(); i++){
        if(n_str[i] != '0'){
            n = i;
            break;
        }
    }
    answer = n_str.substr(n);
    return answer;
}