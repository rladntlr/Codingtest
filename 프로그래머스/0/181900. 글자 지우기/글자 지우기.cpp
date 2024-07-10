#include <bits/stdc++.h>

using namespace std;

string solution(string my_string, vector<int> indices) {
     sort(indices.begin(), indices.end(), greater<int>());

    for(auto c : indices){
        my_string.erase(my_string.begin() + c);
    }

    return my_string;
}