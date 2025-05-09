#include <iostream>
#include <vector>
using namespace std;


int dx[4] = {0, 1,  0, -1};
int dy[4] = {1, 0, -1,  0};

int N;
vector<vector<int>> pan;

void snail(int x, int y, int d, int num) {
    pan[x][y] = num;
    if (num == N * N) return;   

    int nx = x + dx[d];
    int ny = y + dy[d];
    if (nx < 0 || ny < 0 || nx >= N || ny >= N || pan[nx][ny] != 0) {
        d = (d + 1) % 4;
        snail(x, y, d, num);
    } else {
        snail(nx, ny, d, num + 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    for (int tc = 1; tc <= T; ++tc) {
        cin >> N;
        pan.assign(N, vector<int>(N, 0));


        snail(0, 0, 0, 1);

        cout << "#" << tc << "\n";
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                cout << pan[i][j] << " ";
            }
            cout << "\n";
        }
    }

    return 0;
}
