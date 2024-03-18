#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> count(10,0);
    int A, B, C;
    cin >> A >> B >> C;
    int ABC = 0;
    ABC = A*B*C;
    string abc;
    abc = to_string(ABC);
    for(auto num : abc)
        count[num-'0']++;
    for(int i=0;i<count.size();i++)
        cout << count[i] << '\n';
}