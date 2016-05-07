/*Author : Octavio Diaz
*Uva 12150 - Poll Position
* Data Structures
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream print = new PrintStream(System.out);
        int carsStartingP[],n;
        boolean incorrect;
        while((n=Integer.parseInt(br.readLine()))!=0){
            incorrect = false; carsStartingP =  new int[10005];
            for (int i = 1; i <= n ; i++) {
                String input [] =  br.readLine().split("\\s+");
                if(!incorrect) {
                    int carNumber = Integer.parseInt(input[0]);
                    int carPosition = Integer.parseInt(input[1]);
                    int actualPosition = i + carPosition;
                    if (actualPosition < 1 || actualPosition > n) {
                        incorrect = true;
                        continue;
                    }
                    if (carsStartingP[actualPosition] != 0) incorrect = true;
                    carsStartingP[actualPosition] = carNumber;
                }
            }
            if (incorrect) print.printf("-1\n");
            else{
                for (int i = 1; i <=n; i++) {
                    print.printf("%d",carsStartingP[i]);
                    if(i<n) print.printf(" ");
                }
                print.printf("\n");
            }
        }
    }
}
