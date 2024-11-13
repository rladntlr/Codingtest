#include <bits/stdc++.h>
using namespace std;

int a[1000005];
int n;
vector<int> uni;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a[i];
        uni.push_back(a[i]);
    }
    sort(uni.begin(), uni.end());
    uni.erase(unique(uni.begin(), uni.end()), uni.end());
    for(int i = 0; i < n; i++)
        cout << lower_bound(uni.begin(), uni.end(), a[i]) - uni.begin() << '\n';
}