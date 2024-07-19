#include <bits/stdc++.h>

using namespace std;

string solution(string myString) {
    for(auto &c : myString){
        if(c == 'a' || c == 'A') c = 'A';
        else c = tolower(c);
    }
    return myString;
}