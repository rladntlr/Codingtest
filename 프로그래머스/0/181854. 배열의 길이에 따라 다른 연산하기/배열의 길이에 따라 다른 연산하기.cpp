#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr, int n) {
    vector<int> answer;
    int k = arr.size();
    if(k%2==0){
        for(int i = 1; i < k; i+=2)
            arr[i] +=n;
    }
    else{
        for(int i = 0; i < k; i+=2)
            arr[i] +=n;
    }
    return arr;
}