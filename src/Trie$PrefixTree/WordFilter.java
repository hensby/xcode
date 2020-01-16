package Trie$PrefixTree;

import java.util.*;

/**
 * Prefix and Suffix Search
 Given many words, words[i] has weight i.

 Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

 Examples:
 Input:
 WordFilter(["apple"])
 WordFilter.f("a", "e") // returns 0
 WordFilter.f("b", "") // returns -1
 Note:
 words has length in range [1, 15000].
 For each test case, up to words.length queries WordFilter.f may be made.
 words[i] has length in range [1, 10].
 prefix, suffix have lengths in range [0, 10].
 words[i] and prefix, suffix queries consist of lowercase letters only.
 */
public class WordFilter {
    static class TrieNode {
        Map<Integer, TrieNode> children;
        int weight;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insertPrefix(TrieNode cur, String word, int weight, int start) {
            for (int i = start; i < word.length(); i++) {
                char c = word.charAt(i);
                cur = cur.children.computeIfAbsent(getHashCode(c, '`'), k -> new TrieNode());
                cur.weight = weight;
            }
        }

        public void insertSuffix(TrieNode cur, String word, int weight, int start) {
            for (int i = start; i >= 0; i--) {
                char c = word.charAt(i);
                cur = cur.children.computeIfAbsent(getHashCode('`', c), k -> new TrieNode());
                cur.weight = weight;
            }
        }

        public TrieNode addNode(TrieNode cur, char prefixChar, char suffixChar, int weight) {
            cur = cur.children.computeIfAbsent(getHashCode(prefixChar, suffixChar), k -> new TrieNode());
            cur.weight = weight;
            return cur;
        }

        public int search(String prefix, String suffix) {
            TrieNode cur = this.root;
            for (int i = 0, j = suffix.length() - 1; i < prefix.length() || j >= 0; i++, j--) {
                char c1 = i < prefix.length() ? prefix.charAt(i) : '`';
                char c2 = j >= 0 ? suffix.charAt(j) : '`';
                int code = getHashCode(c1, c2);
                cur = cur.children.get(code);
                if (cur == null) {
                    return -1;
                }
            }

            return cur.weight;
        }

        public int getHashCode(char prefixChar, char suffixChar) {
            return (prefixChar - '`') * 27 + (suffixChar - '`');
        }
    }

    private Trie trie;

    public WordFilter(String[] words) {
        this.trie = new Trie();
        for (int weight = 0; weight < words.length; weight++) {
            TrieNode cur = trie.root;
            String word = words[weight];
            int n = word.length();
            for (int i = 0; i < n; i++) {
                // use prefix only
                this.trie.insertPrefix(cur, word, weight, i);
                // use suffix only
                this.trie.insertSuffix(cur, word, weight, n - 1 - i);
                // use prefix + suffix
                // now go to that node
                cur = this.trie.addNode(cur, word.charAt(i), word.charAt(n - 1 - i), weight);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return this.trie.search(prefix, suffix);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
//		char[] arr = new char[] {'`', 'a', 'b', 'c', 'd', 'x', 'y', 'z'};
//		for (int i = 0; i < arr.length; i++) {
//			char prefixChar = arr[i];
//			for (int j = 0; j < arr.length; j++) {
//				char suffixChar = arr[j];
//				int code = trie.getHashCode(prefixChar, suffixChar);
//				System.out.println(String.valueOf(prefixChar) + String.valueOf(suffixChar) + ": " + code);
//			}
//		}
        System.out.println(trie.getHashCode('p', 'l'));
    }
}

