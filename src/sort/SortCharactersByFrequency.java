package sort;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) heap.offer((char)i);
        }

        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0)
                res.append(c);
        }
        return res.toString();
    }

    public String frequencySort1(String s) {
        Map<Character, Integer> occurMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char i: s.toCharArray()) {
            occurMap.put(i, occurMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> Integer.compare(occurMap.get(c2), occurMap.get(c1)));
        for(char i: occurMap.keySet()) {
            if(occurMap.get(i) != 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            char tmp = queue.poll();
            int i = occurMap.get(tmp);
            for(int j = 0; j < i; j++){
                sb.append(tmp);
            }
        }
        return sb.toString();
    }


    public String frequencySort2(String s) {
        int length = s.length();
        if (length <= 1) return s;
        Map<Character, Integer> frequentMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            frequentMap.put(s.charAt(i), frequentMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[length + 1];
        for (int i = 0; i < length + 1; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (char j: frequentMap.keySet()) {
            bucket[frequentMap.get(j)].add(j);
        }
        StringBuilder sb = new StringBuilder();
        for (int k = length; k > 0; k--) {
            for (char current: bucket[k]) {
                int index = 0;
                while (index < frequentMap.get(current)) {
                    sb.append(current);
                    index++;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("aaacccsffffff"));
        System.out.println(sortCharactersByFrequency.frequencySort1("aaacccsffffff"));
        System.out.println(sortCharactersByFrequency.frequencySort2("aaacccsffffff"));


//        Map<Character, Character> map = new HashMap<Character, Character>(){{
//            put('(', ')');
//            put('[', ']');
//            put('{', '}');
//        }};

    }
}
//451. Sort Characters By Frequency
//        Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
//
//
//
//        Example 1:
//
//        Input: s = "tree"
//        Output: "eert"
//        Explanation: 'e' appears twice while 'r' and 't' both appear once.
//        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//        Example 2:
//
//        Input: s = "cccaaa"
//        Output: "aaaccc"
//        Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//        Note that "cacaca" is incorrect, as the same characters must be together.
//        Example 3:
//
//        Input: s = "Aabb"
//        Output: "bbAa"
//        Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//        Note that 'A' and 'a' are treated as two different characters.
//
//
//        Constraints:
//
//        1 <= s.length <= 5 * 105
//        s consists of English letters and digits.