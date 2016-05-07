/*Author: Octavio Diaz
* Uva 12346 - Army Budies
* Data Structures
* */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));

        int n,b,r,l;
        int leftSol[] = new int [100005],  rightSold[] =new int[100005];
        String line;
        StringTokenizer tokenizer ;

        while(!(line=br.readLine()).equals("0 0")){
            tokenizer = new StringTokenizer(line);
            n=Integer.parseInt(tokenizer.nextToken());
            b=Integer.parseInt(tokenizer.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n+1; i++) {
                leftSol[i]=i-1;
                rightSold[i]=i+1;
            }
            while(b-->0){
                tokenizer = new StringTokenizer(br.readLine());
                l = Integer.parseInt(tokenizer.nextToken());
                r = Integer.parseInt(tokenizer.nextToken());
                if(leftSol[l]<1) print.write("* "); else print.write( leftSol[l] +" " );
                if(rightSold[r]>n) print.write("*\n"); else print.write(rightSold[r]+"\n");
                leftSol[rightSold[r]]= leftSol[l];
                rightSold[leftSol[l]] =rightSold[r];
            }
            print.write("-\n");

        }
        print.flush();
        print.close();
    }

}
