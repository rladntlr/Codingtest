#include <bits/stdc++.h>
using namespace std;

int a[10005];
int n;
vector<int> tow;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i = 0 ; i<n; i++) cin >> a[i];
    sort(a, a+n);
    for(int i = 0; i< n; i++){
        for(int j = i; j < n; j++)
            tow.push_back(a[i]+a[j]);
    }
    sort(tow.begin(), tow.end());
    for(int i = n-1; i > 0; i--){
        for(int j = 0; j < i; j++){
            if(binary_search(tow.begin(), tow.end(), a[i]-a[j])){
                cout << a[i];
                return 0;
            }
        }
    }
}