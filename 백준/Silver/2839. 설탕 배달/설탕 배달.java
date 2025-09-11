
import java.util.Scanner;

public class Main {
    static int n, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while (true) {
            if (n < 0) {
                System.out.println(-1);
                break;
            }
            if (n % 5 == 0) {
                System.out.println(cnt + n / 5);
                break;
            }
            n -= 3;
            cnt++;
        }
    }
}
