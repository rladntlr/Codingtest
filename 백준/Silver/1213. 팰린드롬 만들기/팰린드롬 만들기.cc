#include <bits/stdc++.h>
using namespace std;

int cnt[200]; //문자가 얼마나 등장했는지 확인

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int flag = 0; // 홀수로 들어온 문자가 몇개인지 확인 2개 이상이면 팰린드롬 생성 불가
    char mid; // 홀수만큼 있을때 중간에 있을 문자 저장
    string s, ans;
    cin >> s;
    for(auto c : s) cnt[c]++;

    for(int i = 'Z'; i >= 'A'; i--){
        if(cnt[i]){
            if(cnt[i] & 1){
                mid = char(i);
                flag++;
                cnt[i]--;
            }
            if(flag == 2) break;
            for(int j = 0; j < cnt[i]; j+=2){
                ans = char(i) + ans; //문자열의 앞에
                ans += char(i); // 문자열의 뒤에 추가
            }
        }
    }
    if(mid) ans.insert(ans.begin() + ans.size() / 2, mid); //문자가 홀수개 들어오면 하나를 빼서 mid에 두었다가 가운데 넣기
    if(flag == 2) cout << "I'm Sorry Hansoo";
    else cout << ans;
}