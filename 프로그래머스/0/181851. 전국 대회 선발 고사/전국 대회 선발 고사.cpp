#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    int answer = 0;
    vector<pair<int, int>> a; // (등수, 인덱스) 쌍을 저장
    
    for(int i = 0; i < attendance.size(); i++) {
        if(attendance[i]) {
            a.push_back({rank[i], i}); // 등수와 해당 학생의 인덱스를 저장
        }
    }

    // 등수를 기준으로 오름차순 정렬
    sort(a.begin(), a.end());

    // 등수가 작은 3명의 인덱스를 사용해 값을 계산
    answer = a[0].second * 10000 + a[1].second * 100 + a[2].second;
    
    return answer;
}
