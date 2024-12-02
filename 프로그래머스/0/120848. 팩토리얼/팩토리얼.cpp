#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int temp = 1;
    for(int i = 1; i < 12; i++)
    {
        temp *= i;
        if (temp > n) return i - 1;
    }
}