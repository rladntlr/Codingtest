	//
// Created by KIM on 2025-05-08.
//
#include <bits/stdc++.h>
using namespace std;

int price[1000004];

int main(){
    int T;
    cin >> T;

    for(int i = 1; i <= T; i++){
        int N;
        long long ans = 0;
        cin >> N;
        for(int j = 0; j < N; j++){
            cin >> price[j];
        }
        int max_price = price[N-1];for(int j = N-1; j>=0; j--){
            if(max_price >= price[j]){
                ans = ans + (max_price-price[j]);
            }
            else{
                max_price = price[j];
            }
        }
        cout<<"#"<<i<<" "<<ans<<"\n";
        for(int j = 0; j<N; j++){
            price[j] = 0;
        }

    }
    return 0;
}