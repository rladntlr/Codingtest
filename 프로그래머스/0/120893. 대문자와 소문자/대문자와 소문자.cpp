#include <string>
#include <vector>

using namespace std;

string solution(string my_string) {
    string answer = "";
    for(auto& c : my_string){
        if( c >= 'a' && c <= 'z'){
            c -= 32;
        }
        else 
            c += 32;
    }
    return my_string;
}