package binarySearch;

import java.util.*;

public class RandomPickwithWeight {
//
//    //(wsum, index)
//    TreeMap<Integer, Integer> map;
//    public binarySearch.RandomPickwithWeight(int[] w) {
//        map = new TreeMap();
//        map.put(w[0], 0);
//        for(int i = 1; i < w.length; i++){
//            w[i] += w[i - 1];
//            map.put(w[i], i);
//        }
//        System.out.println(map);
//    }
//
//    public int pickIndex() {
//        Random rand = new Random();
//        int target = rand.nextInt(map.lastKey());
//        System.out.println(target);
//        System.out.println(map.higherEntry(target));
//        return map.higherEntry(target).getValue();
//    }


    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public RandomPickwithWeight(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
        System.out.println(psum);
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);
        System.out.println(targ);
        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            System.out.println(lo + " " + hi);
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        RandomPickwithWeight obj = new RandomPickwithWeight(new int[]{1,3,3,3,3,4,5,6,6});
        System.out.println(obj.pickIndex());
//        System.out.println(obj.pickIndex());
//        System.out.println(obj.pickIndex());
    }
}
