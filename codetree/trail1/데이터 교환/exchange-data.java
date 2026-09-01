public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        int a = 5, b = 6, c = 7;
        int temp1, temp2;

        temp1 = b;
        b = a;
        temp2 = c;
        c = temp1;
        a = temp2;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}