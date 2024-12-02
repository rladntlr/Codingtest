#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    for(int i = 0; i < numbers.size()-1; i++){
        for(int j = i+1; j < numbers.size(); j++){
            int mult = numbers[i] * numbers[j];
            answer = max(answer,mult);
        }
    }
    return answer;
}