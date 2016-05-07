/*Author Octavio Diaz
* UVA 10855 - Rotated squares
* Data Structures
* */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream print = new PrintStream(System.out);
        String line, matrix[],submatrix[];
        int n,m, c[];

        while(!(line=br.readLine()).equals("0 0")){
            StringTokenizer tokenizer = new StringTokenizer(line);
            n = Integer.parseInt(tokenizer.nextToken());
            m=Integer.parseInt(tokenizer.nextToken());
            c= new int[4];
            matrix =  new String[n]; submatrix = new String[m];
            for (int i = 0; i <n ; i++) matrix[i] = br.readLine();
            for (int i = 0; i <m ; i++) submatrix[i] = br.readLine();
            c[0] =  compare(matrix,submatrix);
            for (int i=1;i<=3;i++){
                submatrix=rotate(submatrix);
                c[i] = compare(matrix,submatrix);
            }
            print.printf("%d %d %d %d\n",c[0],c[1],c[2],c[3]);

        }
    }

    private static int compare(String [] matrix , String [] subMatrix ){
        int cont=0,in=0;
        boolean notEqual ;
        for (int i = 0; i <= matrix.length-subMatrix.length; i++) {
            for (int j = 0; j <= matrix.length-subMatrix.length; j++){
                in=0; notEqual= true;
                for (int k = i; k <i+subMatrix.length ; k++) {
                    String str = matrix[k].substring(j,j+subMatrix.length);
                    if(! str.equals(subMatrix[in++])){
                        notEqual = false;
                        break;
                    }
                }
                if(notEqual) cont++;
            }
        }
        return cont;
    }
    private static  String [] rotate(String []matrix){
        char [][] rotatedM = new char[matrix.length][matrix.length];
        String aux [] =  new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedM[j][ matrix.length -1-i]= matrix[i].charAt(j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            aux[i] = String.valueOf(rotatedM[i]);
        }

        return aux;
    }
}
