import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //exercices 2.2.1

        //2
        PrintStream print = new PrintStream(System.out);
        int mapNumbers[] =  new int[1000001],v,a,b;
        List<Integer> listNumbers = new ArrayList<>();
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean found=false;

        line =  br.readLine();
        v=  Integer.parseInt(br.readLine());

        for(String n : line.split("\\s+")){
            int aux=  Integer.parseInt(n);
            mapNumbers[aux]=1;
            listNumbers.add(aux);
        }


        for (int i = 0; i < listNumbers.size()  && !found;i++) {
            b = listNumbers.get(i);
            if(mapNumbers[v-b]==1 ){
                found= Boolean.TRUE;
                print.printf("The numbers are %d,%d\n", v - b, b);
            }
        }
        if(!found) print.printf("Nothing found");

        //5
        Collections.sort(listNumbers);
        int lenghtLongestSubArray=1,may=-10;
        for (int i = 0; i < listNumbers.size()-1; i++) {
            if(listNumbers.get(i+1)-listNumbers.get(i)==1){
                lenghtLongestSubArray++;
            }
            else{
                lenghtLongestSubArray = 1;
            }
            if(lenghtLongestSubArray>may){
                may=lenghtLongestSubArray;
            }
        }

        print.printf("longest contiguos subset length : %d",lenghtLongestSubArray+1);

    }
}
