
/**
 * @author Octavio Diaz
 * UVA 10443
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {
        int t,r,c,n;
        char [][] m1,m2;
        String line;
        //Scanner read =  new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        t= Integer.parseInt(br.readLine());
        while(t>0){
            line =  br.readLine();
            String []input =  line.split(" ");
            //r = read.nextInt(); c=  read.nextInt(); n = read.nextInt();
            r=Integer.parseInt(input[0]);
            c=Integer.parseInt(input[1]); 
            n=Integer.parseInt(input[2]);
            m1= new char [r][c];
            m2= new char[r][c];
            for(int i=0;i<r;){                
                line = br.readLine();
                if(line!=null) {
                    m1[i]=  line.toCharArray();
                    i++;                   
                }
            }            
            copyMatriz(m1, m2);
            play(m1,m2,n);
            t--;
            for (char[] m21 : m2) {       
                System.out.println(m21);
            }
            if(t>0) System.out.println();            
        }
        
    }
    
    private static void copyMatriz(char [][]m1 , char [][]m2){
        for (int i = 0; i < m1.length; i++) 
            //m2[i] = m1[i].clone();
           System.arraycopy(m1[i], 0, m2[i], 0, m1[i].length);
    }
    
    private static void play(char [][]m1 , char [][]m2, int n){       
       int r= m1.length,c=m1[0].length; 
       char c1='R',c2='S';
       int []cx={0,0,-1,1};
       int []cy={1,-1,0,0};       
       
       while(n>0){
           for (int i = 0; i < r; i++) {
               for (int j = 0; j <c; j++) {
                   for (int k = 0; k < 3; k++) {
                       for (int z = 0; z <4; z++) {
                           if(i+cx[z]>=0 && i+cx[z]<r && j+cy[z]>=0 && j+cy[z]<c){
                                if(m1[i][j]==c1 && m1[i+cx[z]][j+cy[z]]==c2)
                                    m2[i+cx[z]][j+cy[z]] = c1;                                                
                           }
                       }
                        if(k==0){c1='S';c2='P';} 
                        if(k==1){c1='P';c2='R';}
                   }   
                   c1='R';
                   c2='S';
               }               
           }
           n--;          
           copyMatriz(m2, m1);
       }
    }
}
