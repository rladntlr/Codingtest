//
// Created by KIM on 2025-05-20.
//
#include <bits/stdc++.h>

using namespace std;

int a[201];

int main(){
    int N;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> a[i];
    }
    sort(a,a + N);
    cout << a[N/2];
}