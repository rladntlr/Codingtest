#include<bits/stdc++.h>
using namespace std;
int n, k, ret = -10000004, psum[100004], temp;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    for(int i = 1; i <= n; i++){
        cin >> temp;
        psum[i] = psum[i - 1] + temp;
    }//구간합
    for(int i = k; i <= n; i++){
        ret = max(ret, psum[i] - psum[i - k]);
    }// i에서 k를 빼면 k일 만큼의 누적합이 나옴
    cout << ret;
    return 0;
}