#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while(true){
        string s;
        getline(cin, s);
        if(s==".") break;
        stack<char> stack;
        bool isV = true;
        for(auto c : s){
            if(c=='(' || c=='[') stack.push(c);
            else if(c==')'){
                if(stack.empty() || stack.top()!='('){
                    isV = false;
                    break;
                }
                stack.pop();
            }
            else if(c==']'){
                if(stack.empty() || stack.top()!='['){
                    isV = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.empty()) isV = false;
        if(isV) cout << "yes\n";
        else cout << "no\n";
    }
    return 0;
}