#include <bits/stdc++.h>
#include <vector>

using namespace std;

int solution(vector<vector<int>> lines) {
    int answer=0;
    int arr[201]={0,};
    
    for(int i=0;i<3;i++)
    {
        for(int j=lines[i][0];j<lines[i][1];j++)
        {
            arr[j+100]++;
        }
    }
    
    for(int i=0;i<201;i++)
        if(arr[i]>=2)answer++;
    
    return answer;
}