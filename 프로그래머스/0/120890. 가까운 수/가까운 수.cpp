#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> array, int n) {
    sort(array.begin(), array.end());
    int closest = abs(array[0] - n);
    int pos = 0;
    for(int i = 1; i<array.size(); i++)
    {
        if(closest > abs(array[i] - n)) {
            closest = abs(array[i] - n);
            pos = i;
        }
    }
    return array[pos];
}