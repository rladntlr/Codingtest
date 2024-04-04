#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> num_list) {
    int sum = 0;
    int mul=1;
    for(int i=0;i<num_list.size();i++){
        sum += num_list[i];
        mul = mul * num_list[i];
    }
    if(mul<sum*sum) return 1;
    
    else if(mul>sum*sum) return 0;
}