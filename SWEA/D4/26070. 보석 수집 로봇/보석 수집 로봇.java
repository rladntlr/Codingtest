import java.util.*;
import java.io.*;

public class Solution {static int N, M;
static int[][] map;

// 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
static int[] dr = {0, 1, 0, -1};
static int[] dc = {1, 0, -1, 0};

static final int INF = Integer.MAX_VALUE;

static class State {
	int r;
	int c;
	int dir;
	int nextGem;
	int turned;

	State(int r, int c, int dir, int nextGem, int turned) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.nextGem = nextGem;
		this.turned = turned;
	}
}

static int bfs() {

	// dist[r][c][dir][nextGem][turned]
	int[][][][][] dist =
			new int[N][N][4][M + 2][2];

	for (int r = 0; r < N; r++) {
		for (int c = 0; c < N; c++) {
			for (int d = 0; d < 4; d++) {
				for (int g = 0; g <= M + 1; g++) {
					Arrays.fill(dist[r][c][d][g], INF);
				}
			}
		}
	}

	Deque<State> dq = new ArrayDeque<>();

	// 시작 위치 (0,0), 오른쪽, 1번 보석부터 수집
	dist[0][0][0][1][0] = 0;
	dq.addFirst(new State(0, 0, 0, 1, 0));

	while (!dq.isEmpty()) {

		State cur = dq.pollFirst();

		int r = cur.r;
		int c = cur.c;
		int dir = cur.dir;
		int nextGem = cur.nextGem;
		int turned = cur.turned;

		int cost =
				dist[r][c][dir][nextGem][turned];

		// 모든 보석 수집 완료
		if (nextGem == M + 1) {
			return cost;
		}

		// =========================
		// 1. 앞으로 이동
		// =========================

		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (nr >= 0 && nr < N &&
				nc >= 0 && nc < N) {

			int newNextGem = nextGem;

			// 지금 먹어야 할 보석이면 수집
			if (map[nr][nc] == nextGem) {
				newNextGem++;
			}

			// 이동했으므로 다시 회전 가능
			int newTurned = 0;

			// 이동은 회전 횟수 증가 없음
			if (dist[nr][nc][dir][newNextGem][newTurned]
					> cost) {

				dist[nr][nc][dir][newNextGem][newTurned]
						= cost;

				dq.addFirst(
						new State(
								nr,
								nc,
								dir,
								newNextGem,
								newTurned
								)
						);
			}
		}

		// =========================
		// 2. 오른쪽 회전
		// =========================

		// 이 칸에서 아직 회전하지 않은 경우만 가능
		if (turned == 0) {

			int ndir = (dir + 1) % 4;

			int newTurned = 1;

			// 회전했으므로 비용 +1
			if (dist[r][c][ndir][nextGem][newTurned]
					> cost + 1) {

				dist[r][c][ndir][nextGem][newTurned]
						= cost + 1;

				dq.addLast(
						new State(
								r,
								c,
								ndir,
								nextGem,
								newTurned
								)
						);
			}
		}
	}

	return -1;
}

public static void main(String[] args) throws Exception {

	BufferedReader br =
			new BufferedReader(
					new InputStreamReader(System.in)
					);

	StringBuilder sb = new StringBuilder();

	int T = Integer.parseInt(br.readLine());

	for (int tc = 1; tc <= T; tc++) {

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		M = 0;

		for (int r = 0; r < N; r++) {

			StringTokenizer st =
					new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {

				map[r][c] =
						Integer.parseInt(st.nextToken());

				M = Math.max(M, map[r][c]);
			}
		}

		int answer = bfs();

		sb.append("#")
		.append(tc)
		.append(" ")
		.append(answer)
		.append("\n");
	}

	System.out.print(sb);
}
}