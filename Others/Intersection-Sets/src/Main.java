/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Octa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a1[] = {1,10,5,2};
        int a2[] = {1,2,1,25,2};
        int a3[] = {8,10,5,2,10,50,22,1,1};
        int r[] = new int[10000];
        loopArray(a1, r);
        loopArray(a2, r);
        loopArray(a3, r);
        for(int i=0;i<r.length;i++){
            if(r[i]==3){
                System.out.print(i +",");
            }
        }
    }
    
    private static void loopArray(int [] array, int [] r){
        
        boolean aux[] = new boolean[10000];
        for(int i=0;i<array.length;i++){
            if(aux[array[i]]==false){
                aux[array[i]]=true;
                r[array[i]]++;
            }
        }
    }
    
}
