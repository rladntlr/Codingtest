#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> array) {
    vector<int> check(1001,0);
    int max = 0, maxIndex = 0 , count = 0;
    for(int i = 0; i < array.size();i++){
        check[array[i]]++;
    }
    for(int i = 0; i<check.size();i++){
        if(check[i]>max){
            max = check[i];
            maxIndex=i;
        }
    }
    for(int i = 0; i<check.size();i++){
        if(check[i]==max) count++;
    }
    if(count>1) return -1;
    return maxIndex;
}