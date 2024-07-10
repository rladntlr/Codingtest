#include <string>
#include <vector>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> num(52);
    for(auto c : my_string){
        if( c >='A' && c <='Z'){
            num[c-'A']++;
        }
        else num[c-'a'+26]++;
    }
    return num;
}