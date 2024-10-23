#include <bits/stdc++.h>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    if(a%2==0 && b%2==0){
        answer = a-b;
        if(answer<0){
            answer = -1 * answer;
            return answer;
        }
        return answer;
    }
    else if(a%2!=0 && b%2!=0){
        answer = a*a + b*b;
        return answer;
    }
    else{
        answer = 2 * (a + b);
        return answer;
    }
}