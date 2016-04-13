/*Author : Octavio Diaz
*
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        Scanner read = new Scanner(System.in);
        PrintStream print = new PrintStream(System.out);
        String line;
        int carsNumbers[] , carsPositions[], carsStartingP[];
        int n ;
        boolean incorrect;
        while((n=read.nextInt())!=0){
            carsNumbers = new int[n+1];
            carsPositions = new int[n+1];
            carsStartingP =  new int [n+1];
            incorrect = false;
            for(int i=1;i<=n;i++){
                carsNumbers[i]=read.nextInt();
                carsPositions[i]=read.nextInt();
            }
            for (int i = 1; i <= n && !incorrect; i++) {                
                int actualPosition = i+carsPositions[i];
                if(actualPosition<1 || actualPosition>n) {incorrect = true; break;}
                if(carsStartingP[actualPosition]!=0 ) incorrect =  true;
                carsStartingP[actualPosition] = carsNumbers[i] ;
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
