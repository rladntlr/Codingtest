#include <bits/stdc++.h>

using namespace std;

double solution(vector<int> numbers) {
    int answer = 0;
    for(int i = 0; i < numbers.size();i++)
        answer+=numbers[i];
    return (double)answer/numbers.size();
}