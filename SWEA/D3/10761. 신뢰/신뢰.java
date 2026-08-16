
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int[] pos = {1, 1};
            int[] lastTime = {0, 0};

            int time = 0;

            for (int i = 0; i < N; i++) {

                char robot = st.nextToken().charAt(0);
                int target = Integer.parseInt(st.nextToken());

                int r;

                if (robot == 'B') {
                    r = 0;
                } else {
                    r = 1;
                }

                int distance = Math.abs(pos[r] - target);

                int elapsed = time - lastTime[r];

                if (distance > elapsed) {
                    time += distance - elapsed;
                }
                
                time++;

                pos[r] = target;
                lastTime[r] = time;
            }

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(time)
                    .append("\n");
        }

        System.out.print(sb);
    }
}