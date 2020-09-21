package robinhood;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static int divisorSubstrings(int n, int k) {
        if (n == 0 || k == n) { return 0; } // get all substrings
        String str = Integer.toString(n);
        int len = str.length();
        int count = 0;
        if(n % k == 0) return 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= len - k; i++) {
            String cur = str.substring(i, i + k);
            System.out.println(cur);
            int tmp = Integer.parseInt(cur);
            System.out.println(tmp);
            if (n % tmp == 0) {
                if(set.contains(tmp)) continue;
                count ++;
                set.add(tmp);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(divisorSubstrings(1, 1));
        System.out.println(1 % 1);
    }
}
