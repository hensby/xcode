package robinhood;

import java.util.LinkedList;
import java.util.List;

public class countSaw {
    List<List<Integer>> res = new LinkedList<>();
    int k = 2;
    int[] arr;

    public long countSawSubarrays(int[] arr) {
        this.arr = arr;
        trackBack(new LinkedList<>(), 0, 0);
        System.out.println(res);
        return 9090;
    }

    public void trackBack(LinkedList<Integer> tmpRes, int len, int index) {
        if(len == k) {
            res.add(new LinkedList<>(tmpRes));
            return;
        }
        for(int i = index; i < arr.length; i++) {

            tmpRes.add(arr[i]);
            trackBack(tmpRes, len + 1, i + 1);
            tmpRes.removeLast();

        }
    }

//    List<List<Integer>> res = new LinkedList<>();
//    int k = 2;
//    int[] arr;
//
//    long countSawSubarrays(int[] arr) {
//        int result = 0;
//        this.arr = arr;
//        trackBack(new LinkedList<>(), 0, 0);
//        for(int i = 0; i < res.size(); i++) {
//
//            if(res.get(i).get(1) > res.get(i).get(0)) result++;
//        }
//        return result;
//    }
//
//    void trackBack(LinkedList<Integer> tmpRes, int len, int index) {
//        if(len == k) {
//            res.add(new LinkedList<>(tmpRes));
//            return;
//        }
//        for(int i = index; i < arr.length; i++) {
//
//            tmpRes.add(arr[i]);
//            trackBack(tmpRes, len + 1, i + 1);
//            tmpRes.removeLast();
//
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new countSaw().countSawSubarrays(new int[]{9, 8, 7, 6, 5}));
    }
}
