/* Author : Octavio Diaz
   Uva  11581 - Grid Successors
   Data Structures
* */
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream print = new PrintStream(System.out);
        int t;
        int m[][] = new int[3][3] , a[][] = new  int [3][3];
        t=Integer.parseInt(br.readLine());
        while(t-->0){
            br.readLine();
            for (int i = 0; i < 3; i++)
                m[i] =  stringToArray(br.readLine());

            print.printf("%d\n", transform(m,a));
        }

    }

    static int transform(int [][] m , int [][]a){
        int x[]= {-1,1,0,0};
        int y[]= {0,0,1,-1};
        int index = -1,sum =0;

        while(check(m)){
            index++;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    sum = 0;
                    for (int k = 0; k < 4; k++) {
                        if (i + x[k] > -1 && i + x[k] < m.length && j + y[k] > -1 && j + y[k] < m[0].length) {
                            sum += m[i + x[k]][j + y[k]];
                        }
                    }
                    a[i][j] = sum % 2;
                }
            }
            for (int i = 0; i < m.length; i++)
                System.arraycopy(a[i],0, m[i],0,a[0].length);

        }
        return index;
    }

    static boolean check(int [][] m){
        boolean found = false;
        for (int i = 0; i <3 && !found; i++) {
            String line = Arrays.toString(m[i]);
            if (!line.equals("[0, 0, 0]")) found = true;
        }
        return found;
    }

    static int [] stringToArray(String line ){
        int array[] = new int [3];
        for (int i = 0; i < line.length(); i++)
            array[i]= (int)line.charAt(i) -48;
        return array;
    }
}
