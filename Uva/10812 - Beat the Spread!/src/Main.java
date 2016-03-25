/**Uva 10812 - Beat the Spread!
 * Simulation
 * @author Octavio Diaz
 */
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
       int  t, sum ,diff;
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       t=  Integer.parseInt(br.readLine());
       while(t-- > 0){
           String line =  br.readLine();
           String []input = line.split("\\s+");
           sum=Integer.parseInt(input[0]); 
           diff =Integer.parseInt(input[1]);
           int cont =sum;
           boolean found = false;
           for (int i = 0; i <= sum && found!=true; i++) {
               if(Math.abs(i-cont)==diff){
                   System.out.println(cont+" "+i);
                   found =true;
               }
               cont--;
           }
           if(!found){
               System.out.println("impossible");
           }
           
           
       }
    }

}
