package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 438
public class FindAllAnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
        for(char ch : p.toCharArray()){
            needs[ch - 'a'] ++;
        }
        while(right < s.length()){
            System.out.println(Arrays.toString(window));
            char chr = s.charAt(right);
            if(needs[chr - 'a'] > 0){
                window[chr - 'a'] ++;
                if(window[chr - 'a'] <= needs[chr - 'a']){
                    total --;
                }
            }
            while(total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0){
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']){
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }


    public List<Integer> findAnagrams1(String s, String p) {
        // 用于返回字母异位词的起始索引
        List<Integer> res = new ArrayList<>();
        // 用 map 存储目标值中各个单词出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        // 用另外一个 map 存储滑动窗口中有效字符出现的次数
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0; // 左指针
        int right = 0; // 右指针
        int valid = p.length(); // 只有当 valid == 0 时，才说明 window 中包含了目标子串
        while (right < s.length()) {
            System.out.println(window);
            // 如果目标子串中包含了该字符，才存入 window 中
            if (map.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                    valid--;
                }
            }
            System.out.println(window + " " + valid);
            // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
            // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
            while (valid == 0) {
                if (right - left + 1 == p.length()) res.add(left);
                // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                if (map.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                        valid++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd", p =  "abc";
        FindAllAnagramsString f = new FindAllAnagramsString();
        System.out.println(f.findAnagrams1(s, p));
    }
}
