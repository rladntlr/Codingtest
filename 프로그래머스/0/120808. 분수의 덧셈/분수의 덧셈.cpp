#include <bits/stdc++.h>

using namespace std;

int gcd(int a, int b){
    if(a%b==0) return b;
    return gcd(b, a%b);
}

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int>answer;
    int denom = denom1 * denom2;
    int numer = numer1 * denom2 + numer2 * denom1;
    
    int c = gcd(denom,numer);
    
    answer.push_back(numer/c);
    answer.push_back(denom/c);
    
    return answer;
}