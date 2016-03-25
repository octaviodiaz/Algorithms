/*
 * @author Octavio.Diaz
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        //s sister card , p prince card
        byte s1, s2, s3, p1, p2;
        while (true) {            
            s1 = read.nextByte();
            s2 = read.nextByte();
            s3 = read.nextByte();
            p1 = read.nextByte();
            p2 = read.nextByte();
            if (s1 == 0) return;
            boolean found=false;
            for (byte i = 1; i <= 52; i++) {
                if(i!=s1 && i!=s2 && i!=s3 && i!=p1 && i!=p2)
                {
                    if(evaluate(s1,s2,s3,p1,p2,i)){
                        System.out.println(i);
                        found=true;
                        break;
                    }
          
                }               
            }
            if(!found) System.out.println("-1");
        }
    }   
    
    private static boolean evaluate(byte s1,byte s2,byte s3,byte p1,byte p2,byte p3){
       
        byte cp1=p1,cp2=p2,cp3=p3,cs1=s1,cs2=s2,cs3=s3;
        
        for(byte i =1;i<=3;i++){         
            if(i==2){
                //exchange s1 && s2
                s2=cs1;
                s1=cs2;
            }   
            if (i==3){
                //exchange s1 && s3
               s1=cs3;
               s2=cs1;
               s3=cs2;
            }
            if(!posibility(s1,p1,s2,p2,s3,p3)) return false;
            if(!posibility(s1,p1,s2,p3,s3,p2)) return false;
            if(!posibility(s1,p1,s3,p2,s2,p3)) return false;
            if(!posibility(s1,p1,s3,p3,s2,p2)) return false;

            if(!posibility(s1,p2,s2,p1,s3,p3)) return false;
            if(!posibility(s1,p2,s2,p3,s3,p1)) return false;
            if(!posibility(s1,p2,s3,p1,s2,p3)) return false;
            if(!posibility(s1,p2,s3,p3,s2,p1)) return false;

            if(!posibility(s1,p3,s2,p1,s3,p2)) return false;
            if(!posibility(s1,p3,s2,p2,s3,p1)) return false;
            if(!posibility(s1,p3,s3,p1,s2,p2)) return false;
            if(!posibility(s1,p3,s3,p2,s2,p1)) return false;
        
        }       
        
        return true;
    }
    
    private static  boolean max(byte s,byte p){
        return (s>p);
    }
    
    private static boolean posibility(byte cs1,byte cp1,byte cs2,byte cp2,byte cs3,byte cp3){
        if(max(cs1,cp1)){
            if(max(cs2,cp2)) return false;
            else if (max(cs3,cp3)) return false;
            else return true;
        }
        else if (!max(cs2,cp2)) return true;
        else if(!max(cs3,cp3)) return true;
        else  return false;          
    }
}
