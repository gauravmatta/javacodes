import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.function.Function;

public class Train {
//    private Hashtable<Integer, Integer> wagons;
    private final Deque<Hashtable<Integer, Integer>> wagons;
    
    public Train(int wagonCount, Function<Integer, Integer> fillWagon) {
        this.wagons = new LinkedList<>();

        for (int i = 0; i < wagonCount; i++) {
        	
        	this.wagons.addFirst((Hashtable<Integer, Integer>) new Hashtable().put(i, fillWagon.apply(i)));
//          this.wagons.put(i, fillWagon.apply(i));
        }
    }

//    public int peekWagon(int wagonIndex) {
//        return this.wagons.get(wagonIndex);
//    }
//    
//    public static void main(String[] args) {
//        Train train = new Train(10, wagonIndex -> wagonIndex);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
//        }
//    }
}