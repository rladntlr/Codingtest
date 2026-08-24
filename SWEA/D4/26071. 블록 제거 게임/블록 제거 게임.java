import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
    static int[] arr;
    static boolean[] broken;
    static int maxScore;

    static void dfs(int depth, int score) {

        if (depth == N) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = 0; i < N; i++) {

            if (broken[i]) continue;

            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && broken[left]) {
                left--;
            }

            while (right < N && broken[right]) {
                right++;
            }

            int getScore;

            if (left >= 0 && right < N) {
                getScore = arr[left] * arr[right];
            }

            else if (left >= 0) {
                getScore = arr[left];
            }

            else if (right < N) {
                getScore = arr[right];
            }

            else {
                getScore = arr[i];
            }

            broken[i] = true;

            dfs(depth + 1, score + getScore);

            broken[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            broken = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0;

            dfs(0, 0);

            sb.append("#").append(tc)
              .append(" ").append(maxScore)
              .append("\n");
        }

        System.out.print(sb);
    }

}
