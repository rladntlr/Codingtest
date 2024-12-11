#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int answer = INT_MIN;
    int maxmult = 0;
    for(int i = 0; i < numbers.size()-1; i++){
        for(int j = i+1 ;j < numbers.size(); j++){
            maxmult = numbers[i] * numbers[j];
            answer = max(maxmult, answer);
        }
    }
    return answer;
}