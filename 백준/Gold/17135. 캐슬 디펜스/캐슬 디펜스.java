import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 조합 ( 궁수 3명을 x 좌표 어느 곳에 배치 )
// 조합이 완성이 되면 규칙에 따라 시물레이션
//   궁수로부터 가장 가까이 있는 적
//      bfs 로 처리한다면 2차원 배열 탐색 -> 2차원 배열 활용
//      PriorityQueue 로 가장 가까운 적 -> 좌표를 가지고 처리 가능
public class Main {
    static int N, M, D, max;
    static int[] archer = new int[3]; // 궁수 3명 x 좌표 // tgt
    static List<Enemy> enemyCopy = new ArrayList<>(); // 복사 원본 - 최초 상태 유지
    static List<Enemy> enemy = new ArrayList<>(); // 시뮬레이션 진행

    static PriorityQueue<Enemy> pqueue = new PriorityQueue<>(  // 궁수와의 거리 d 가 같으면 x 기준 다르면 d 기준
            (e1, e2) -> e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d
    );

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        // 적 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if( n == 1 ) enemyCopy.add(new Enemy(i, j)); // 적을 복사 원본 List 에 담는다.
            }
        }

        comb(0, 0); // x 좌표 가장 왼쪽,  archar 첫 번째
        System.out.println(max);
    }
    // 현재 선택된 궁수의 자리에서 시물레이션 진행
    static void check() {
        // 적 좌표 초기화
        enemy.clear();
        for (Enemy e : enemyCopy) {
            enemy.add(new Enemy(e.y, e.x)); // 동일좌표의 새로운 객체를 만들어서 초기화
        }

        // 시물레이션
        int deadCnt = 0;
        while(true) {

            // 3명의 궁수가 활을 쏜다.
            for (int i = 0; i < 3; i++) { // archer[0~2]

                // 각 궁수마다 가장 가까운 거리의 적에게 발사
                pqueue.clear();

                int ac = archer[i];
                int size = enemy.size();

                // 유효거리 D 안에 있는 모든 적을 pqueue 에 담는다.
                for (int j = 0; j < size; j++) {
                    Enemy e = enemy.get(j);
                    // 현재 궁수와 적(e) 의 거리를 계산
                    e.d = Math.abs(ac - e.x) + Math.abs(N - e.y);
                    if( e.d > D ) continue;

                    pqueue.offer(e); // enemy, pqueue 는 객체 공유
                }

                // 유효 사격 거리 D 안에 해당하는 적이 있으면, 죽음 표시
                if( ! pqueue.isEmpty() ) {
                    pqueue.poll().dead = true;
                }
            }

            // 죽은 적 제거
            // 적들이 아래로 이동
            for (int i = enemy.size() - 1; i >= 0; i--) { // 컬렉션에서 삭제할 때 오류 방지, 뒤부터 작업
                Enemy e = enemy.get(i);
                if( e.dead ) {
                    enemy.remove(i); // 사망자 처리
                    deadCnt++;
                }else if( e.y == N - 1 ) { // 아래로 사라지는 적
                    enemy.remove(i);
                }else {
                    e.y++; // 남은 적 아래로 한 칸씩 이동
                }
            }

            // 적들이 모두 사라지면 while 종료(죽거나, 밑으로 사라지거나)
            if( enemy.size() == 0 ) break;
        }

        max = Math.max(max, deadCnt);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if( tgtIdx == 3 ) {
            // complete code
            // 시물레이션
            check();
            return;
        }

        if( srcIdx == M ) return;

        archer[tgtIdx] = srcIdx; //

        comb(srcIdx + 1, tgtIdx + 1); // 선택
        comb(srcIdx + 1, tgtIdx); // 비선택
    }

    static class Enemy{
        int y, x, d; // 궁수와의 거리
        boolean dead; // 사망 여부

        // d, dead 는 시물레이션 과정에서 사용
        Enemy(int y, int x){
            this.y = y; this.x = x;
        }
    }
}
