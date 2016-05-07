/*Author : Octavio Diaz
Uva 11093 - Just Finish it up
Data structures
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream print = new PrintStream(System.out);
        int t,n ,gasAtStation[],gasNeeded[], diff[];
        List<Integer> candidates ;
        boolean found  ;
        t=Integer.parseInt(br.readLine());
        for (int c = 0; c <t ; c++) {
            n = Integer.parseInt(br.readLine());
            found =  false;
            gasAtStation = new int[n]; gasNeeded = new int[n]; diff= new int[n];
            candidates  = new ArrayList<>();
            readArray(gasAtStation,br.readLine());
            readArray(gasNeeded,br.readLine());
            for (int i = 0; i < n ; i++) {
                diff[i] = gasAtStation[i] -gasNeeded[i];
                if(diff[i]>-1){ candidates.add(i); found = true;}
            }
            if(!found) print.printf("Case %d: Not possible\n",c+1);
            else{
                found  = false;
                for (int cd:candidates)
                    if(checkCandidate(cd,diff)) {
                        print.printf("Case %d: Possible from station %d\n", c + 1, cd+1);
                        found = true;
                        break;
                    }
                if(!found) print.printf("Case %d: Not possible\n",c+1);
            }
        }
    }

    private static boolean checkCandidate(int from, int [] diff){
        int sum = diff[from];
        int count= diff.length-1;
        while (count-->0) {
            if(from+1 == diff.length) from= 0;
            else from++;
            sum+=diff[from];
            if(sum<0) return false;
        }
        return true;
    }

    private static void readArray(int [] array, String line){
        String []aux =line.split("\\s+");
        for (int i = 0; i <array.length; i++) {
            array[i] =  Integer.parseInt(aux[i]);
        }
    }

}
