import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitalSum {
    public List<Integer> getSum(int[] l1, int[] l2) {
        int len1 = l1.length, len2 = l2.length, carry = 0;
        List<Integer> res = new ArrayList<>();
        while(len1 > 0 || len2 > 0) {
            int val1 = len1 == 0 ? 0 : l1[len1 - 1];
            int val2 = len2 == 0 ? 0 : l1[len2 - 1];
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            res.add(0,sum % 10);
            if(len1 != 0) len1--;
            if(len2 != 0) len2--;
        }
        if (carry > 0) res.add(0,carry);
        return res;
    }

    public static void main(String[] args) {
        DigitalSum d = new DigitalSum();
        int[] l1 = new int[] {9,2,2};
        int[] l2 = new int[] {9,9};
        System.out.println(Arrays.equals(l1,l2));
        System.out.println(d.getSum(l1, l2));
    }
}
//    Write a function to return the sum of two arbitrarily large positive integers.
//
//        Example calls with the return value
//        sum([1], [3,2]) // returns [3,3]
//        sum([1,0,2], [4,8]) // returns [1,5,0]
//        sum([1,4,1,2,3,1,2,1,2,3,1,1,1,1,1,2,2,2,2,3,3,3,1,1,3,4,5,1,2,1,3,1,8,8,2,3,4],[1]) // [1,4,1,2,3,1,2,1,2,3,1,1,1,1,1,2,2,2,2,3,3,3,1,1,3,4,5,1,2,1,3,1,8,8,2,3,5]