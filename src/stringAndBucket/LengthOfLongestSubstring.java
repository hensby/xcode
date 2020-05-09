package stringAndBucket;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right),right);
            max = Math.max(max,right-left+1);
            right ++;
        }
        return max;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String input = "pwwkew";
        System.out.println(l.lengthOfLongestSubstring(input));
    }
}
