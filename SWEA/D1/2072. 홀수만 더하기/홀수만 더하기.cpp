#include <iostream>
using namespace std;

int main() {
    int test_case, T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case) {
        int k, sum = 0;
        for (int i = 0; i < 10; i++) {
            cin >> k;
            if (k % 2 != 0)
                sum += k;
        }
        cout << '#' << test_case << ' ' << sum << '\n';
    }
    return 0;
}
