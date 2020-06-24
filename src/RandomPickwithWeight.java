import java.util.Random;
import java.util.TreeMap;

public class RandomPickwithWeight {

    //(wsum, index)
    TreeMap<Integer, Integer> map;
    public RandomPickwithWeight(int[] w) {
        map = new TreeMap();
        map.put(w[0], 0);
        for(int i = 1; i < w.length; i++){
            w[i] += w[i - 1];
            map.put(w[i], i);
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int target = rand.nextInt(map.lastKey());
        return map.higherEntry(target).getValue();
    }

}
