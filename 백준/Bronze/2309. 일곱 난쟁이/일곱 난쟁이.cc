#include <bits/stdc++.h>
using namespace std;

int a[9];
int main(){
    cin.tie(0);
    ios::sync_with_stdio(0);

    for(int i = 0 ; i < 9; i++){
        cin >> a[i];
    }
    sort(a, a+9);//순열을 사용할때는 무조건 정렬하고
    do{
        int sum = 0;
        for(int i = 0 ; i < 7; i++) sum += a[i];
        if(sum == 100) break;//sum이 100 되면 while탈출
    } while (next_permutation(a, a+9));
    for(int i = 0; i < 7; i++){
        cout << a[i] << "\n";
    }
    return 0;
}