import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);
        long A,B,C;


            A = sc.nextLong();
            B = sc.nextLong();
            C = sc.nextLong();
            ps.println(Math.atan((double)A/(double)B));

            if((A*A + B*B == C*C)) {
                ps.println("rectangulo");
            }
            else if(true) {
                ps.println("acutangulo");
            }
            else {
                ps.println("obtusangulo");
            }


    }
}
