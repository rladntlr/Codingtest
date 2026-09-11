import java.util.*;

class Solution {

    static int answer;
    static int len;
    static int[] weak2;

    public int solution(int n, int[] weak, int[] dist) {

        len = weak.length;
        weak2 = new int[len * 2];

        // 원형을 직선처럼 펴기
        for (int i = 0; i < len; i++) {
            weak2[i] = weak[i];
            weak2[i + len] = weak[i] + n;
        }

        answer = dist.length + 1;

        int[] selected = new int[dist.length];
        boolean[] visited = new boolean[dist.length];

        permutation(0, dist, selected, visited);

        if (answer == dist.length + 1) {
            return -1;
        }

        return answer;
    }

    static void permutation(int cnt, int[] dist, int[] selected, boolean[] visited) {

        // 친구 순서 하나 완성
        if (cnt == dist.length) {

            // 시작 취약점 결정
            for (int start = 0; start < len; start++) {

                int friendCnt = 1;

                // 첫 번째 친구가 start 지점에서 출발
                int position = weak2[start] + selected[0];

                // start부터 취약점 len개 확인
                for (int i = start; i < start + len; i++) {

                    // 현재 친구가 이 취약점까지 못 감
                    if (weak2[i] > position) {

                        friendCnt++;

                        // 친구를 다 사용한 경우
                        if (friendCnt > selected.length) {
                            break;
                        }

                        // 다음 친구가 현재 취약점에서 출발
                        position = weak2[i] + selected[friendCnt - 1];
                    }
                }

                answer = Math.min(answer, friendCnt);
            }

            return;
        }

        // 친구 순열 만들기
        for (int i = 0; i < dist.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            selected[cnt] = dist[i];

            permutation(cnt + 1, dist, selected, visited);

            visited[i] = false;
        }
    }
}