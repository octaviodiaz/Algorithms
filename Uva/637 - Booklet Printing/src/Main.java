
import java.io.*;

/**
 * 637 - Booklet Printing 
 * Simulation
 * @author Octavio Diaz
 */
public class Main {

    public static void main(String[] args) throws IOException {
        int n,blankPages=0,totalPages=0,contMax=0,contMin=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((n = Integer.parseInt(br.readLine()))!=0){
            System.out.println("Printing order for "+n+" pages:");
            if(n==1) System.out.println("Sheet 1, front: Blank, 1");
            else{
                int cont =1;
                blankPages = (n % 4) == 0 ? 0 : 4-(n%4);
                totalPages = n+blankPages;
                contMax =  totalPages;
                contMin = 1;
                for (int i = 1;i<=totalPages/4;) {
                    String page;
                    if(blankPages>0){
                        page="Blank";
                        blankPages--;
                    }
                    else
                        page = String.valueOf(contMax);                    
                    if (cont%2==0){
                        System.out.println("Sheet "+i+ ", back : "+contMin+", "+page); 
                        i++;
                    }
                    else{
                        System.out.println("Sheet "+i+ ", front: "+page+", "+contMin);
                    }
                    
                    cont++;
                    contMin++;
                    contMax--;  
                }
            }
        }
        
    }
    
}
