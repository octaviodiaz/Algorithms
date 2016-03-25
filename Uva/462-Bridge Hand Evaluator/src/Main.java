import java.io.*;
import java.util.*;

class Pair {
    int points;
    int cards;
    boolean stopped;

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }
}

public class Main  {

    public static void main(String[] args) throws IOException {
        Map<Character,Pair> suits ;

        String line;
        String [] cards ;
        int points , extraRulesPoints;
        char mostCards ;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while((line =  reader.readLine())!=null) {
            points = 0;
            mostCards = 0;extraRulesPoints=0;
            suits = new TreeMap<Character, Pair>();
            suits.put('S', new Pair());
            suits.put('H', new Pair());
            suits.put('D', new Pair());
            suits.put('C', new Pair());
            cards = line.split(" ");
            checkRules(cards,suits);

            boolean allStopped  = true;
            int mayor = -10;
            List<Pair> values =  new ArrayList<Pair>(suits.values());
            List<Character> keys  =  new ArrayList<Character>(suits.keySet());

            for(int i=values.size()-1;i>=0;i--){
                Pair entry =  values.get(i);
            
          //  for(Map.Entry<Character,Pair> entry:suits.entrySet()){
                if(!entry.isStopped()) {
                    allStopped = false;
                }
                points+= entry.getPoints();
                if(entry.getCards()>mayor){
                    mayor =  entry.getCards();
                    mostCards = keys.get(i);
                }
                if(entry.getCards()==2) extraRulesPoints+=1;
                else if(entry.getCards()==0 || entry.getCards()==1) extraRulesPoints+=2;
            }

            if(points+extraRulesPoints<14) System.out.println("PASS");
            else if(points>=16 && allStopped) System.out.println("BID NO-TRUMP");
            else {
                System.out.println("BID "+mostCards );
            }
        }
    }

 /*   private static void sortMap(Map<Character,Pair> map){
        List<Map.Entry<Character,Pair>> list =  new LinkedList<Map.Entry<Character,Pair>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character,Pair>>() {
            @Override
            public int compare(Map.Entry<Character, Pair> o1, Map.Entry<Character, Pair> o2) {
                if(o1.getValue().getPoints()==o2.getValue().getPoints()){

                    return o2.getKey().compareTo(o1.getKey());
                }
                else{
                  return   o1.getValue().getPoints() - o2.getValue().getPoints();
                }
            }
        });
    }*/


    private static void checkRules(String [] cards,Map<Character,Pair> suits){

        for (String card : cards) {
             char number = card.charAt(0);
            int pointsToAdd = 0;
            Pair pair = suits.get(card.charAt(1));
            if(number == 'A') pointsToAdd=4;
            if(number == 'K') pointsToAdd=3;
            if(number == 'Q') pointsToAdd=2;
            if(number == 'J') pointsToAdd=1;
            pair.setPoints(pair.getPoints()+pointsToAdd);
            pair.setCards(pair.getCards()+1);
            suits.put(card.charAt(1),pair);
        }

        for (String card : cards) {
            char number =  card.charAt(0);
            char suit  =  card.charAt(1);
            Pair pair = suits.get(suit);
            if(number == 'A' || (number == 'K' && suits.get(suit).getCards()>=2)
                    || (number == 'Q' && suits.get(suit).getCards()>=3))
                pair.setStopped(true);

            if((number=='K' && pair.getCards()==1) ||(number=='Q' && pair.getCards()<=2)
                    ||(number=='J' && pair.getCards()<=3 ) )
                pair.setPoints(pair.getPoints()-1);

            suits.put(suit, pair);
        }
    }

}
