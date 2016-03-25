
/**
 *
 * @author Octa
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<String,String> map = new HashMap<>();      
        List<String> rAnanagrams = new ArrayList<String>();
        while( (line=br.readLine()) !=null){
            if(line.equals("#")) break;
            String [] words= line.split(" ");
            for(String word : words){
                char aux[] = word.toLowerCase().toCharArray();
                Arrays.sort(aux);
                String wordSorted = Arrays.toString(aux);
                if(map.containsKey(wordSorted)){
                    map.put(wordSorted,"");                       
                }
                else{
                    map.put(wordSorted,word);
                }
            }         
            
        }
        
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(!entry.getValue().equals("")){
                rAnanagrams.add(entry.getValue());
            }
        }
        Collections.sort(rAnanagrams);
        for(String rAnanagram: rAnanagrams){
            System.out.println(rAnanagram);
        }
        
    }
    
}
