package binaryTree;

import java.util.*;

public class FindAllConcatenatedWordsInADict {
    private Set<String> dict = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict.addAll(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (dfs(word, 0, 0)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean dfs(String word, int idx, int cnt) {
        if (idx == word.length()) {
            return cnt > 1;
        }
        for (int i = idx; i < word.length(); i++) {
            if (dict.contains(word.substring(idx, i + 1))) {
                if (dfs(word, i + 1, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindAllConcatenatedWordsInADict findAllConcatenatedWordsInADict = new FindAllConcatenatedWordsInADict();
        String[] s = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict.findAllConcatenatedWordsInADict(s));
    }
}
//      472. Concatenated Words
//        Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
//        A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
//
//        Example:
//        Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
//
//        Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//
//        Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
//        "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
//        "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".