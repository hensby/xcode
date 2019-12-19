import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    public int[] intersection2(int[] nums1, int[] nums2) {
        // Sort both arrays, use two pointers Time complexity: O(nlogn)
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        return set.stream().mapToInt(Number::intValue).toArray();
    }

    public int[] intersection(int[] a, int[] b){
        Set<Integer> tmp = new HashSet<Integer>(), res = new HashSet<Integer>();
        for (int i : a){
            tmp.add(i);
        }
        for (int j : b){
            if (tmp.contains(j)){
                res.add(j);
            }
        }
        return res.stream().mapToInt(Number::intValue).toArray();

    }

    public int[] intersection3(int[] a, int[] b) {
        if (a.length > b.length) return intersection3(b, a);
        Set<Integer> res = new HashSet<Integer>();
        Arrays.sort(a);
        Arrays.sort(b);
        int l = 0, r = b.length;
        for (int i: a){
            int index = Arrays.binarySearch(b,l,r,i);
            if (index >= 0){
                res.add(i);
                l = index+1;
            }else {
                index = -(index + 1);
                if (index >= r) {
                    break;
                }
                l = index;
            }
        }
        return res.stream().mapToInt(Number::intValue).toArray();

    }

    public static void main(String[] args) {
        IntersectionofTwoArrays intersectionofTwoArrays = new IntersectionofTwoArrays();
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,3,4,5,6};
        System.out.println(Arrays.toString(intersectionofTwoArrays.intersection(a, b)));
        System.out.println(Arrays.toString(intersectionofTwoArrays.intersection2(a, b)));
        System.out.println(Arrays.toString(intersectionofTwoArrays.intersection3(a, b)));
    }
}
