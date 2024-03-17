#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int ans = 0;
    string a_str, b_str, anb, bna;
    a_str = to_string(a);
    b_str = to_string(b);
    
    anb = a_str + b_str;
    bna = b_str + a_str;
    
    if(anb > bna){
       return ans = stoi(anb);
    }
    else return ans = stoi(bna);
}