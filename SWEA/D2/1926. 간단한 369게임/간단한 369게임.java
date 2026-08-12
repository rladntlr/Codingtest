
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c == '3' || c == '6' || c == '9') {
                    count++;
                }
            }

            if (count == 0) {
                sb.append(i);
            } else {
                for (int j = 0; j < count; j++) {
                    sb.append("-");
                }
            }

            sb.append(" ");
        }

        sb.append("\n");


        System.out.print(sb);
    }
}