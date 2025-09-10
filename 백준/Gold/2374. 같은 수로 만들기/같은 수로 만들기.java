
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;

        int current = Integer.parseInt(br.readLine());
        int max = current;

        for(int i = 1; i < n; i++){
            int next = Integer.parseInt(br.readLine());
            max = Math.max(max, next);
            if (current <= next) {
                ans += next - current;
            }
            current = next;
        }
        ans += max - current;

        System.out.println(ans);
        br.close();
    }
}
