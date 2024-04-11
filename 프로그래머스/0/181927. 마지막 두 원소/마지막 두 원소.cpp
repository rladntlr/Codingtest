#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int len = num_list.size()-1;
    if(num_list[len] > num_list[len-1])
        num_list.push_back(num_list[len] - num_list[len-1]);
    else
        num_list.push_back(num_list[len] * 2 );
    return num_list;
    
}