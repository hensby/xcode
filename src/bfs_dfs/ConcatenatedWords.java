package bfs_dfs;

import java.util.*;
//lc 472
public class ConcatenatedWords {
    private Set<String> dict = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict.addAll(Arrays.asList(words));
        List<String> ans = new ArrayList<>(words.length);
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
        String[] input = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        System.out.println(concatenatedWords.findAllConcatenatedWordsInADict(input));
    }
}

