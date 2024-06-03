import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadder {
    static List<String> players;
    static List<Snake> snakes;
    static List<Ladder> ladders;
    final static int boardSize = 10;
    static boolean finish;
    static Map<String,Integer> positions;
    public SnakeAndLadder(){
        players = new ArrayList<>();
        players.add("Yash");
        players.add("Sonu");
        players.add("Baby");

        this.finish = false;
        snakes = new ArrayList<>();
        snakes.add(new Snake(3,2));
        snakes.add(new Snake(9,8));

        ladders = new ArrayList<>();
        ladders.add(new Ladder(4,5));
        ladders.add(new Ladder(7,8));

        positions = new HashMap<>();
        for(String p : players){
            positions.put(p,0);
        }
    }
    public class Pair{
        int a,b;
        Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
    public class Snake extends Pair{
        Snake(int a, int b) {
            super(a, b);
        }
    }
    public class Ladder extends Pair{
        Ladder(int a,int b){
            super(a,b);
        }
    }
    public static void playGame(){
        while(!finish){
            for(String aplayer : positions.keySet()){
                int rolled = (int) rollDice();
//                System.out.printf("Rolled dice value : "+rolled);
                int nextPos = positions.get(aplayer) + rolled;
                if(nextPos ==boardSize) {
                    System.out.println("We have aplayer winner :: "+ aplayer);
                    finish = true;
                }
                if(nextPos <boardSize){

                for(int i=0; i< ladders.size();i++){
                      if(ladders.get(i).a == nextPos) {
                          nextPos = ladders.get(i).b;
                          positions.put(aplayer,nextPos);
                          System.out.println("Bit by snake "+ aplayer +" demoted to : "+nextPos);
                      }
                }
                for(int i=0; i< snakes.size();i++){
                    if(snakes.get(i).a == nextPos) {
                        nextPos = ladders.get(i).b;
                        positions.put(aplayer,nextPos);
                        System.out.println("Climbed by ladder "+ aplayer +" promoted to : "+nextPos);
                    }
                }
                positions.put(aplayer,nextPos);

                }
            }
        }
    }
    public static double rollDice(){
        //Dice of 3
        return Math.random() * 3;
    }
    public static void main(String[] args) {
        System.out.println("Snak and lad Initiate");
        SnakeAndLadder s1 = new SnakeAndLadder();
        s1.playGame();
    }
}
