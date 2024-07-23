#include <bits/stdc++.h>

using namespace std;

int solution(string binomial) {
    int answer = 0;
    stringstream ss(binomial);
    int a, b;
    char op;
    ss >> a >> op >> b;
    switch(op){
        case '+' : return a+b;
        case '-' : return a-b;
        case '*' : return a*b;
    }
}