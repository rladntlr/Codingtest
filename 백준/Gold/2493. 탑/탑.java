import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int heigth = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < heigth) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
            }
            else {
                result[i] = stack.peek()[0] + 1;
            }
            stack.push(new int[]{i, heigth});
        }
        for (int i = 0; i < n; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
