#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    int C;
    cin >> C;
    string s;
    
    for(int i = 1; i <= C; i++) {
        cin >> s;
        int month = stoi(s.substr(4, 2));
        int day = stoi(s.substr(6));
        
        cout << "#" << i << " ";
        
        if(1 <= month && month <= 12 && 1 <= day && day <= dayOfMonth[month - 1]) {
            cout << s.substr(0, 4) << "/" << s.substr(4, 2) << "/" << s.substr(6) << '\n';
        } else {
            cout << -1 << '\n';
        }
    }
}
