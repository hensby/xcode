package Amazon_oa;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PrimeAirTime {

    private static List<int[]> getClosestPairs1(int[][] A, int[][] B, int target) {

        TreeMap<Integer, List<Integer>> valueWithIds = new TreeMap<>();

        List<int[]> result = new ArrayList<>();

        int closestTarget = 0;
  /*
       Loop through the first Array and insert the values into the map with 'value' (A[1]) as key and id (A[0]) add to the list as value.
  */
        for (int[] a : A) {
            int currentTarget = a[1], id = a[0];
            valueWithIds.putIfAbsent(currentTarget, new ArrayList<>());
            valueWithIds.get(currentTarget).add(id);
        }

        System.out.println(valueWithIds);

        for (int[] b : B) {
            int remainingTarget = target - b[1];  // We will find the remaining target by the value from the value of B.
            // For example if target = 5000, b[1] = 3000, then remainingTarget = 2000

            if (remainingTarget < 0) continue;

            if (valueWithIds.containsKey(remainingTarget)) { // That means we find the closest target == currentTarget
                if (closestTarget != target) {
                    closestTarget = target;
                    result = new ArrayList<>();
                }
                for (int id : valueWithIds.get(remainingTarget)) {

                    result.add(new int[]{id, b[0]});
                }
            } else {
                Integer floor = valueWithIds.floorKey(remainingTarget);  // Check if we have any least value which is less than remainingTarget.

                if (floor == null) continue;

                int currentTarget = b[1] + floor;

                if (currentTarget >= closestTarget) {
                    if (currentTarget != closestTarget) {
                        closestTarget = currentTarget;
                        result = new ArrayList<>();
                    }
                    for (int id : valueWithIds.get(floor)) {
                        result.add(new int[]{id, b[0]});
                    }
                }
            }
        }
        return result;
    }

    private static List<int[]> getClosestPairs(int[][] A, int[][] B, int target) {
        if (A.length == 0|| B.length == 0 || target == 0) return null;
        List<int[]> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> valueIdMap = new TreeMap<>();
        for (int[] a: A) {
            valueIdMap.putIfAbsent(a[1], new ArrayList<>());
            valueIdMap.get(a[1]).add(a[0]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int[] b: B) {
            int remainTarget = target - b[1];
            if (valueIdMap.containsKey(remainTarget)) {
                if (maxSum != target) {
                    res.clear();
                }
                maxSum = target;
                for (int i: valueIdMap.get(remainTarget)) {
                    res.add(new int[] {i, b[0]});
                }
            } else {
                Integer floorNum = valueIdMap.floorKey(remainTarget);
                if (floorNum == null) continue;
                int tmpSum = floorNum + b[1];
                if (tmpSum >= maxSum) {
                    if (tmpSum > maxSum) {
                        res.clear();
                        maxSum = tmpSum;
                    }
                    for (int i: valueIdMap.get(floorNum)) {
                        res.add(new int[] {i, b[0]});
                    }
                }
            }
        }
        return res;
    }


        public static void main(String[] args) {
        int[][] arr1 = {{1, 2000}, {2, 3000}, {3, 4000}, {4, 2000}};
        int[][] arr2 = {{1, 5000}, {2, 3000}};

        List<int[]> re = getClosestPairs(arr1, arr2, 7500);

        for (int[] r : re) {
            System.out.println(r[0] + " " + r[1]);
        }

        int[][] arr3 = {{1, 2000}, {2, 3000}, {3, 4000}};
        int[][] arr4 = {{1, 5000}, {2, 3000}};

        List<int[]> re1 = getClosestPairs(arr3, arr4, 5000);

        for (int[] r : re1) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
}
//    This problem is a variant of closest pair sum. You'll be given two arrays
//        arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
//        arr2 = { { 1, 5000 }, {2, 3000} }
//        the first element of every pair represents id and the second value represents the value.
//        and a target x = 5000
//        Find the pairs from both the arrays whose vaue add upto a sum which is less than given target and should be close to the target.
//
//        Output for the above example:
//        { {1, 2} } // Note that the output should be in id's
//
//        I cleared all the test cases for the first problem (will share), but for this problem, I couldn't clear 3 test cases which were of handling duplicates!
//        In the online assesment this problem was sort of tagged as approximate solution, does anyone know what that means?
//        Awaiting for the result!


