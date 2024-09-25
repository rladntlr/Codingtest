#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[100002];
int dist1[1002][1002];
int dist2[1002][1002];
int n,m;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;

    fill(board,board+100001,-1);
    board[n] = 0;
    queue<int> Q;
    Q.push(n);
    while(board[m]==-1){
        auto cur = Q.front();
        Q.pop();
        for(int next : {cur+1, cur-1, 2*cur}){
            if(next < 0 || next > 100000) continue;
            if(board[next] != -1) continue;
            board[next] = board[cur] +1;
            Q.push(next);
        }
    }
    cout << board[m];
}