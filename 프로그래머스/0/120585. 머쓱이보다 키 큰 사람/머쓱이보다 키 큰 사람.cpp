#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<int> array, int height) {
    // 람다 표현식에서 height를 캡처하여 비교
    int under_height = count_if(array.begin(), array.end(),
                                [height](int under_height) { return under_height > height; });
    
    return under_height;
}
