#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;
    while (T--){
        string func, arr;
        deque<int> dq;
        bool isR = 0, isE = 0;
        int num, k = 0;
        cin >> func >> num >> arr;
        for(int i = 1; i+1 < arr.size();i++){
            if(arr[i]==','){
                dq.push_back(k);
                k=0;
            }
            else{
                k = 10 * k + (arr[i] - '0');
            }
        }
        if(k!=0) dq.push_back(k);
        for(auto c : func){
            if(c=='R'){
                isR = !isR;
            }
            else{
                if(dq.empty()){
                    isE = 1;
                    break;
                }
                if(!isR) dq.pop_front();
                else dq.pop_back();
            }
        }
        if(isE) cout << "error\n";
        else{
            if(isR) reverse(dq.begin(),dq.end());
            cout << '[';
            for(int i = 0; i < dq.size(); i++){
                cout << dq[i];
                if(i+1 != dq.size()) cout << ',';
            }
            cout << "]\n";
        }
    }

}