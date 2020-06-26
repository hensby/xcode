package binarySearch;

import java.util.*;
//528
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


//    List<Integer> psum = new ArrayList<>();
//    int tot = 0;
//    Random rand = new Random();
//
//    public RandomPickwithWeight(int[] w) {
//        for (int x : w) {
//            tot += x;
//            psum.add(tot);
//        }
//        System.out.println(psum);
//    }
//
//    public int pickIndex() {
//        int targ = rand.nextInt(tot);
//        System.out.println(targ);
//        int lo = 0;
//        int hi = psum.size() - 1;
//        while (lo != hi) {
//            System.out.println(lo + " " + hi);
//            int mid = (lo + hi) / 2;
//            if (targ >= psum.get(mid)) lo = mid + 1;
//            else hi = mid;
//        }
//        return lo;
//    }


    int[] addUps;
    Random random = new Random();

    public RandomPickwithWeight(int[] w) {

        //千万不要对数组w进行排序，否则就打乱了原有数据的概率分布
        addUps = w;
        for(int i = 0; i < w.length-1; i++) { //累积和 放入数组addUps
            addUps[i+1] = addUps[i] + addUps[i+1];
        }

    }

    public int pickIndex() {
        int maxBound = addUps[addUps.length-1];

        int x = random.nextInt(maxBound); //生成的随机数，范围为[0, maxBound)

        return binarySearch(x); //二分查找
    }

    private int binarySearch(int x) { //返回第一个大于x的下标
        int low = 0;
        int high = addUps.length-1;

        while (low <= high) {
            int mid = low + ((high - low)>>1); //右移1位，相当于除以2。即 low + (high-low)/2，即相当于(high+low)/2

            if(addUps[mid] > x) {
                if(mid == 0 || addUps[mid-1] <= x) { //返回第一个大于x的下标
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1; //没有查找到
    }


    public static void main(String[] args) {
        RandomPickwithWeight obj = new RandomPickwithWeight(new int[]{1,3,3,3,3,4,5,6,6});
        System.out.println(obj.pickIndex());
//        System.out.println(obj.pickIndex());
//        System.out.println(obj.pickIndex());
    }
}
