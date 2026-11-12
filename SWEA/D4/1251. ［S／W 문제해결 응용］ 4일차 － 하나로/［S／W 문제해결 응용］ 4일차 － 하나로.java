import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent = new int[N];
            for(int i = 0; i < N; i++){
                parent[i] = i;
            }
            long[] dx = new long[N];
            long[] dy = new long[N];
            for(int i = 0; i < N; i++){
                dx[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                dy[i] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());

            int M = N * (N - 1) / 2;

            long[][] edge = new long[M][3];

            int idx = 0;

            for(int i = 0; i < N-1; i++){
                for(int j = i + 1; j < N; j++){
                    long x = dx[i] - dx[j];
                    long y = dy[i] - dy[j];

                    edge[idx][0] = i;
                    edge[idx][1] = j;
                    edge[idx][2] = x * x + y * y;
                    idx++;
                }
            }
            Arrays.sort(edge, (a, b) -> Long.compare(a[2], b[2]));

            long sum = 0;
            int cnt = 0;
            for(long[] e : edge){
                if(union((int)e[0], (int)e[1])){
                    sum += e[2];
                    cnt++;
                    if(cnt == N - 1) break;
                }
            }
            System.out.println("#" + tc + " " + Math.round(sum * E));
        }
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if( a== b) return false;
        parent[b] = a;
        return true;
    }
}
/*
1. 간선 만들기

문제에 간선이 주어지지 않았고, 어느 두 섬이든 연결할 수 있어요. 그럼 후보 간선은 어떤 쌍들일까요?
(i, j)와 (j, i)는 같은 터널이니 한 번만 넣도록 반복문 범위를 잡아 보세요.
간선 하나에 어떤 값 3개가 저장되어야 하는지 정하고, 그걸 담을 방법(클래스, 배열 등)을 고르세요.
N이 최대 1,000일 때 간선이 몇 개인지도 계산해 보세요.

2. 비용 정하기

비용은 E * L²인데, 정렬 순서를 정할 때 E가 꼭 필요할까요? E는 모든 간선에 똑같이 곱해져요.
L²을 구하는 데 Math.sqrt가 필요할까요?
좌표 차이는 최대 1,000,000이에요. 제곱하면 얼마이고, int끼리 곱해도 괜찮을까요? 여기가 이 문제의 대표적인 함정이에요.

3. 정렬

비용 기준 오름차순으로 정렬하세요. 이때 비교 기준을 long 값에 맞게 쓰세요.

4. 하나씩 고르기

간선을 앞에서부터 보면서, 두 섬이 이미 연결되어 있으면 건너뛰고 아니면 선택해요. 이 판단을 union-find가 맡아요.
선택할 때마다 비용을 누적하세요.
간선을 몇 개 골랐을 때 멈춰도 될까요? N개의 섬을 잇는 데 필요한 간선 수를 생각해 보세요.

5. 출력

누적한 L² 합에 E를 곱하고, 소수 첫째 자리에서 반올림해서 #C 답 형식으로 출력하세요.
반올림한 결과가 정수로 찍히는지, 지수 표기(1.0E12 같은 형태)로 나오지 않는지 확인하세요.
N=1이면 답이 어떻게 나오는지도 확인해 보세요.
 */