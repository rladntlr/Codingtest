#include <climits>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main(void) {
    int T;
    int directX[4] = {-1, 1, 0, 0};
    int directY[4] = {0, 0, -1, 1};

    cin >> T;

    for (int t = 1; t <= T; t++) {
        int N;

        cin >> N;

        vector<vector<int>> board(N, vector<int>(N, 0));
        vector<vector<int>> distance(N, vector<int>(N, 9999));
        queue<pair<int, int>> q;

        for (int i = 0; i < N; i++) {
            string s;
            cin >> s;
            
            for(int j = 0; j < N; j++){
                board[i][j] = s[j] - '0';
            }
        }

        q.push({0, 0});
        distance[0][0] = 0;

        while(q.size()){
            int x = q.front().first;
            int y = q.front().second;

            q.pop();

            for (int i = 0; i < 4; i++){
                int nx = x + directX[i];
                int ny = y + directY[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(distance[nx][ny] > distance[x][y] + board[nx][ny]){
                        distance[nx][ny] = distance[x][y] + board[nx][ny];
                        q.push({nx, ny});
                    }
                }
            }
        }

        cout << "#" << t << " " << distance[N - 1][N - 1] << endl;
    }
}