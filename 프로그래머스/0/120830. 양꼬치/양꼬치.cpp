#include <bits/stdc++.h>

using namespace std;

int solution(int n, int k) {
    int a = n / 10;
    return n * 12000 + (k - a) * 2000;
}