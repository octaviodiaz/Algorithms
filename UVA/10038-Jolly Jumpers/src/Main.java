
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean diff[];
        int[] numbers;

        while((line=br.readLine())!=null){
            String [] input = line.split("\\s+");
            numbers =  new int[Integer.parseInt(input[0])];
            diff =  new boolean[Integer.parseInt(input[0])+1];
            for (int i=1;i<input.length;i++)
                numbers[i-1]=  Integer.parseInt(input[i]);
            jolly(diff,numbers);
        }
    }

    private static void jolly(boolean [] diff, int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int dif = Math.abs(numbers[i] - numbers[i + 1]);
            if(dif<numbers.length) diff[dif] = true;
        }

        boolean flag = false;
        for (int i = 1; i < numbers.length && !flag; i++) {
            if (!diff[i]) {
                flag = true;
                System.out.println("Not jolly");
            }
        }
        if (!flag) System.out.println("Jolly");
    }
}
