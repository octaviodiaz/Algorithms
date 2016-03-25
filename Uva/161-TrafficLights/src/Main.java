/**
 * @author Octa
 * Uva 161-Traffic Lights
 */
import java.io.*;
import java.util.*;
public class Main { 
    
    static class Light {
        public boolean time[] = new boolean[20000];
        public  int cycleTime; 

        public Light(int sync) {
            this.cycleTime = sync;
        }             
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        List<Light> lights = new ArrayList<>();
        String line;
        int minorCycleTime=10000;         
        
        while((line=br.readLine())!=null){
           
            String []input = line.split("\\s+");
            if(input.length>2){
                if(input[0].equals("0") && input[1].equals("0") && input[2].equals("0")) break;
            }
            for(int i=0;i<input.length;i++){
                if(input[i].equals("")) continue;
                if(input[i].equals("0")) {
                    process(lights,minorCycleTime);
                    minorCycleTime= 10000;
                    break;
                }
                int aux= Integer.parseInt(input[i]);
                if(aux<minorCycleTime) minorCycleTime=aux;
                lights.add(new Light(aux));
            }
            
        }        
        
    }
    
    private static void process(List<Light> lights,int minorCycleTime){
        
        calculate(lights);
            boolean found =  false;
            for (int i = minorCycleTime+1; i <=18001; i++) {
                if(allTurnGreen(lights, i)){
                    int time= i-1;
                    int h=time/3600;
                    int m = (time%3600)/60;
                    int s= (time%3600)%60;
                    System.out.printf("%02d:%02d:%02d\n",h,m,s);               
                    found = true; break;
                }
            }
            if(!found) System.out.println("Signals fail to synchronise in 5 hours");
            lights.clear();          
    }
    
    private static boolean allTurnGreen(List<Light> lights, int time){
        for(Light light:lights){
            if(!light.time[time]) return false;
        }
        return true;           
    }
    
    private static void calculate(List<Light> lights){
        for(Light light:lights){
            int from=1, to;
            Arrays.fill(light.time,from,light.cycleTime-4,Boolean.TRUE);
            while(from<=18000){
                from+=light.cycleTime*2;
                to = from+light.cycleTime-5;  
                Arrays.fill(light.time,from,to,Boolean.TRUE);
            }
            
        }
    }    
    
}
