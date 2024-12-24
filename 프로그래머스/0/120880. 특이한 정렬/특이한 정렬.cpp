#include <bits/stdc++.h>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numlist, int n) {
    // 사용자 정의 정렬 함수
    sort(numlist.begin(), numlist.end(), [n](int a, int b) {
        int distA = abs(a - n); // a와 n의 거리
        int distB = abs(b - n); // b와 n의 거리

        // 거리가 같으면 더 큰 수를 앞에 배치
        if (distA == distB) return a > b;

        // 거리 순으로 정렬
        return distA < distB;
    });

    return numlist;
}