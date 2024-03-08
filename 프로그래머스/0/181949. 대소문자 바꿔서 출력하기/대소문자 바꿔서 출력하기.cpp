#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string str;
    cin >> str;

    for (auto c : str)
    {
        if ('a' <= c && c <= 'z')
            c -= 'a' - 'A';
        else
            c += 'a' - 'A';
        cout << c;
    }
    return 0;
}
