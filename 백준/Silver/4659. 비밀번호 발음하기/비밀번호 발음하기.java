import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean hasAeiou = false, isBad = false;
            int aStraight = 0, bStraight = 0;

            for(int i=0;i<str.length();i++){

                char c = str.charAt(i);
                if(aeiou(c)){
                    hasAeiou = true;
                    aStraight++;
                    bStraight = 0;
                }
                else{
                    bStraight++;
                    aStraight = 0;
                }

                if(aStraight >= 3 || bStraight >= 3){
                    isBad = true;
                    break;
                }

                if(i > 0&& str.charAt(i) == str.charAt(i-1) && c != 'e' && c != 'o'){
                    isBad = true;
                    break;
                }
            }
            System.out.println("<" + str + "> is " + ((isBad || !hasAeiou) ? "not " : "") + "acceptable.");
        }
    }

    static boolean aeiou(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
