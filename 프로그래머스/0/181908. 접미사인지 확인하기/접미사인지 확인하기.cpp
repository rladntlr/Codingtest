#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string is_suffix) {
    for(int i = 0; i < my_string.size(); i++){
        string s = my_string.substr(i);
        if(s==is_suffix) return 1;
    }
    return 0;
}