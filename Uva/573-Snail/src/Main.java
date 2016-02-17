
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        short h,d,f,day;
        double factor,u,climbed;
        boolean first_day=false;
        while(true){
            h=read.nextShort();u=read.nextShort();d=read.nextShort();f=read.nextShort();
            if(h==0 && u==0 && d==0 && f==0) return;
            climbed =0;day =0;first_day=false;factor=u*(f/100.00);
            while(true){
                if(first_day ==true) u-=factor;
                if(u<0) u=0;                
                climbed +=u;
                day++;
                if(climbed>h) {
                    System.out.println("success on day "+day);
                    break;
                }
               climbed-=d;
               if(climbed<0){
                    System.out.println("failure on day "+day);
                    break;
               }
               first_day=true; 
            }
        }
    }
    
}
