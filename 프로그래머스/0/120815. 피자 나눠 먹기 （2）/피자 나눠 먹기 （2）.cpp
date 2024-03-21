#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b){
    if(b==0) return a;
    else return gcd(b,a%b);
}

int solution(int n) {
    int answer=0;
    answer = n/gcd(n, 6);
    return answer;
}