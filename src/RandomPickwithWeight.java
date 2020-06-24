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
        System.out.println(map);
    }

    public int pickIndex() {
        Random rand = new Random();
        int target = rand.nextInt(map.lastKey());
        System.out.println(target);
        System.out.println(map.higherEntry(target));
        return map.higherEntry(target).getValue();
    }


//    int[] wsum;
//    public Solution(int[] w) {
//        wsum = w;
//        for(int i = 1; i < wsum.length; i++){
//            wsum[i] += wsum[i - 1];
//        }
//    }
//
//    public int pickIndex() {
//        Random rand = new Random();
//        int target = rand.nextInt(wsum[wsum.length - 1]) + 1;
//        int start = 0;
//        int end = wsum.length - 1;
//        while(start + 1 < end){
//            int mid = start + (end - start)/2;
//            if(wsum[mid] <= target){
//                start = mid;
//            }else{
//                end = mid;
//            }
//        }
//        if(wsum[start] >= target){
//            return start;
//        }
//        return end;
//    }

    public static void main(String[] args) {
        RandomPickwithWeight obj = new RandomPickwithWeight(new int[]{1,3});
        System.out.println(obj.pickIndex());
//        System.out.println(obj.pickIndex());
//        System.out.println(obj.pickIndex());

    }

}
