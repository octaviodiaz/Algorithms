/*Author Octavio Diaz
* UVA 10920 - Spiral Tab
* Data Structures*/

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(System.out);
        String line;
        int n,i,r,c,m,s;

        while(!(line=br.readLine()).equals("0 0")) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            m = Integer.parseInt(tokenizer.nextToken());
            n = Integer.parseInt(tokenizer.nextToken());
            r=m/2; i=1;
            while(n>i*i){
                i+=2;
                r++ ;
            }
            c=r;
            s= m-c; // indicates the remaining rows/columns from the located ring to the border
            int a = (i-2) * (i-2) , b=(i-1)*(i-1) ,d= i*i;
            int e= (b-a)/2;
            if(n>a && n<=a+1+e)
                print(ps,r+1,s+(a+1+e)-n);
            else if (n>a+e+1 && n<= b)
                print(ps,b-n+s+1,s);
            else if (n> b && n<= (b+1+((d-b)/2)))
                print(ps,s,s+(n-(b+1)));
            else
                print(ps,s+1+(n-((b+1+((d-b)/2))+1)),c+1);

        }
    }

    static void print(PrintStream ps , int x, int y){
        ps.printf("Line = %d, column = %d.\n",x,y);
    }
}

/*  Naive Solution first implemented - which gives every time RE because of the size of the matrix
*   if(p==1) print.printf("Line = %d, column = %d.\n", s/2, s/2);
            if(s==1)  print.printf("Line = %d, column = %d.\n", 1, 1);
            else {
                A:while (true) {
                    if (cont % 2 == 0) m++;
                    for (int i = 0; i < m; i++) {
                        switch (dir) {
                            case 1:x--; break;
                            case 2:y--; break;
                            case 3:x++; break;
                            case 4:y++; break;
                        }
                        spiral[x][y] = ++n;
                        if (n == p) {
                            print.printf("Line = %d, column = %d.\n", s - x, y + 1);
                            break A;
                        }
                        if (n == s * s) break A;
                    }
                    cont++;
                    dir++;
                    if (dir == 5) dir = 1;
                }
            }*/