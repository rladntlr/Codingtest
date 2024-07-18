#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> arr) {
    vector<int> copy = arr;
    int cnt = 0;
    while(1){
        for(auto& c : arr){
            if(c>=50 && c&0) c/=2;
            else if(c < 50 && c&1) c = c*2+1;
        }
        if(copy == arr) return cnt;
        else{
            cnt++; 
            copy = arr;
        }
    }
}