#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for(auto& s : myString){
        if(s<'l')
            s = 'l';
    }
    return myString;
}