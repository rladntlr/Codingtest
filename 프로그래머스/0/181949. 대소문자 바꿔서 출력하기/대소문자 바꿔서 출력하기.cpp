#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string str;
    cin >> str;
    
    for(char ch : str){
        if(isupper(ch)) 
            cout << (char)tolower(ch);
        else 
            cout << (char)toupper(ch);
    }
    return 0;
}
