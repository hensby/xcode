package SlidingWindow;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(S == null || S.length() < K){
            return 0;
        }

        int [] map = new int[26];
        int runner = 0;
        int count = 0;
        int res = 0;
        while(runner < S.length()){
            if(map[S.charAt(runner)-'a']++ > 0){
                count++;
            }

            if(runner >= K){
                if(map[S.charAt(runner-K)-'a']-- > 1){
                    count--;
                }
            }

            if(runner >=K-1 && count == 0){
                res++;
            }

            runner++;
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "havefunonleetcode";
        int K = 5;
        FindKLengthSubstringsWithNoRepeatedCharacters f = new FindKLengthSubstringsWithNoRepeatedCharacters();
        System.out.println(f.numKLenSubstrNoRepeats(S, K));
    }
}

//          LeetCode 1100. Find K-Length Substrings With No Repeated Characters
//
//        Given a string S, return the number of substrings of length K with no repeated characters.
//
//        Example 1:
//
//        Input: S = "havefunonleetcode", K = 5
//        Output: 6
//        Explanation:
//        There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
//        Example 2:
//
//        Input: S = "home", K = 5
//        Output: 0
//        Explanation:
//        Notice K can be larger than the length of S. In this case is not possible to find any substring.
//        Note:
//
//        1 <= S.length <= 10^4
//        All characters of S are lowercase English letters.
//        1 <= K <= 10^4
