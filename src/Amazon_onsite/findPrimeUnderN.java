package Amazon_onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findPrimeUnderN {

    public static List<Integer> findPrimeUnderN (int n) {
        if (n < 2) return new ArrayList<>();
        boolean[] isPrime = new boolean[n]; // false;
        Arrays.fill(isPrime,true);
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i*i < n; i++) { // sqrt(n) log n
            if (isPrime[i]) {
                int jjjj = i;
                while (i * jjjj < n) { //  i = 2, j = 2
                    if (isPrime[i * jjjj]) isPrime[i * jjjj] = false;
                    jjjj++;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPrimeUnderN(120));
    }
}
// gived positive integer n. find all primes less than n;
// 14-> [2,3,5,7,11,13]