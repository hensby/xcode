package gragh;

public class NumSimilarGroups {
    /**
     * 839.Similar String Groups
     * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
     * <p>
     * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
     * <p>
     * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
     * <p>
     * We are given a list A of unique strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
     * <p>
     * Example 1:
     * <p>
     * Input: ["tars","rats","arts","star"]
     * Output: 2
     * Note:
     * <p>
     * A.length <= 2000
     * A[i].length <= 1000
     * A.length * A[i].length <= 20000
     * All words in A consist of lowercase letters only.
     * All words in A have the same length and are anagrams of each other.
     * The judging time limit has been increased for this question.
     */
    public int numSimilarGroups(String[] A) {
        int n = A.length; // n words
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            u.id[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (!u.find(i, j) && isSimilar(A[i], A[j])) {
                    u.union(i, j);
                }
            }
        }
        return u.count;
    }

    private boolean isSimilar(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < word1.length(); ++i) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (++diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }

//    private void swap(char[] a, int i, int j) {
//        char tmp = a[i];
//        a[i] = a[j];
//        a[j] = tmp;
//    }



    public static void main(String[] args) {
        String[] A= new String[] {"tars","rats","arts","star"};
        NumSimilarGroups numSimilarGroups = new NumSimilarGroups();
        System.out.println(numSimilarGroups.numSimilarGroups(A));
    }
}
