#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int arr[3];
    int a, b, c;
    for(int i = 0; i < 3; i++) cin >> arr[i];
    sort(arr, arr+3);
    for(auto i : arr)
        cout << i << " ";
}