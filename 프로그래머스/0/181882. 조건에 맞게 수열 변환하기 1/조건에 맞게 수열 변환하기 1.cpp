#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    for(auto &c : arr){
        if(c >= 50 && c%2==0) c = c/2;
        else if(c<50 && c%2!=0) c = c*2;
    }
    return arr;
}