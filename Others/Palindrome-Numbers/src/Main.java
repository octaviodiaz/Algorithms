
/**
 * @author Octa
 */
public class Main {

    
    public static void main(String[] args) {
        int n = 12320,aux,lenght=0;
        boolean isPal =true;
        aux = n;
        while(aux!=0){
            aux/=10;
            lenght++;
        }       
        
        for(int i=1;i<=lenght/2;i++){
            if(getNumber(n, i)!=getNumber(n, lenght-i+1)){
                System.out.println("No palindrome");
                isPal =false;
                break;
            }
        }
        if(isPal)
            System.out.println("Palindrome");
        
    }
    private static int getNumber(int n,int position){
        int cont=0,number;
        while(n!=0){
            number=n%10; 
            n = n/10;
            cont++;
            if(position==cont)
                return number; 
        }
        
        return 0;
    }
}
