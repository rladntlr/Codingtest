#include <bits/stdc++.h>
using namespace std;

int cnt[103];
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    int A, B, C, sum = 0;
    cin >> A >> B >> C;
    int a, b;
    for(int i = 0; i < 3; i++){
        cin >> a >> b;
        for(int j = a; j < b; j++) cnt[j]++; // cnt 배열에 겹치는 시간 체크 이상 미만
    }
    for(int i = 1; i < 100; i++){
        if(cnt[i]){
            if(cnt[i] == 1) sum += A;
            else if(cnt[i] == 2) sum += 2*B;
            else if(cnt[i] == 3) sum += 3*C;
        }
    }
    cout << sum;
    return 0;
}