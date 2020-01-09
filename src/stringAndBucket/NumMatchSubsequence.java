package stringAndBucket;

import java.util.*;

public class NumMatchSubsequence {
    public ArrayList<String> numMatchingSubseq(String S, String[] words) {
        // key is char and value is index of words in the bucket
        Map<Character, Set<Integer>> buckets = new HashMap<>();
        // use first character to arrange words into buckets
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            buckets.computeIfAbsent(c, k -> new HashSet<>()).add(i);
            System.out.println(buckets);
        }

        // key is index of words and value is its current pointing char index
        Map<Integer, Integer> indexes = new HashMap<>();
        int count = 0;
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            Set<Integer> wordIndexes = buckets.remove(c);
            if (wordIndexes == null || wordIndexes.isEmpty()) {
                // empty bucket
                continue;
            }
            System.out.println(buckets);
            System.out.println(indexes);


            for (int wordIndex : wordIndexes) {
                String word = words[wordIndex];
                int newIndex = indexes.getOrDefault(wordIndex, 0) + 1;
                if (newIndex >= word.length()) {
                    count++;
                    res.add(words[wordIndex]);
                    indexes.remove(wordIndex);
                    continue;
                }
                buckets.computeIfAbsent(word.charAt(newIndex), k -> new HashSet<>()).add(wordIndex);
                indexes.put(wordIndex, newIndex);
                System.out.println(indexes);

            }
        }
        return res;
//        return count;
    }

    public static void main(String[] args) {
        NumMatchSubsequence numMatchSubsequence = new NumMatchSubsequence();
        String S = "abcde";
        String[] nums = new String[]{"a", "bb", "acd", "ace"};
        System.out.println(numMatchSubsequence.numMatchingSubseq(S, nums));
    }
}
