#include <bits/stdc++.h>

using namespace std;
vector<string> v = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

long long solution(string numbers) {
    long long answer = 0;
    int num;
    for(int i = 0; i < v.size(); i++){
        while((num = numbers.find(v[i])) != string::npos){
            numbers.replace(num, v[i].size(), to_string(i));
        }
        }
    answer = stoll(numbers);
    return answer;
}