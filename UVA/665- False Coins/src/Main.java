/*Author: Octavio Diaz
Uva 665- False Coins
Data Structures
* */
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream print = new PrintStream(System.out);
        int m,k,n;
        boolean coins[] ;
        String weight;

        m =  Integer.parseInt(br.readLine());
        while(m-->0){
            String blankLin=br.readLine(); //blank line
            String line  =  br.readLine();
            String input[] = line.split("\\s+");
            n =  Integer.parseInt(input[0]);
            k =  Integer.parseInt(input[1]);
            coins =  new boolean[n+1];
            while(k-->0){
                line=br.readLine();
                weight=br.readLine();
                input =   line.split("\\s+");
                if(weight.equals("=")){
                    for (int i=1;i<input.length;i++){
                        coins[Integer.parseInt(input[i])] = true;
                    }
                }
            }
            printResult(coins,print);
            if(m>0) print.println();
        }

    }

    static void printResult(boolean [] coins ,PrintStream p){
        int cont =0,coin = 0;
        for (int i = 1; i < coins.length; i++) {
            if(!coins[i]){
                cont ++;
                coin = i;
                if(cont>1) break;
            }
        }
        p.println( (cont>1)  ? "0" : coin) ;
    }
}
