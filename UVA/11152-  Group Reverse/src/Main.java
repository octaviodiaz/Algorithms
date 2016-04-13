
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        PrintStream print = new PrintStream(System.out);
        String line, str;
        int n;
        while(!(line=br.readLine()).equals("0")){
            String input[] = line.split("\\s+");
            n  = Integer.parseInt(input[0]);
            str= input[1];
            int lenghtW= (int)Math.ceil(((double)str.length()/(double)n));
            int from =0, to = lenghtW;
            for (int i = 0; i <n; i++) {
                if(i>0){
                    if(to+lenghtW>=str.length()) to  = str.length();
                    else to+=lenghtW;
                }
                String s = new StringBuilder(str.substring(from, to)).reverse().toString();
                print.print(s);
                from =  to;
            }
            print.printf("\n");
        }

    }
}
