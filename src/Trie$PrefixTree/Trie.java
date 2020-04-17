package Trie$PrefixTree;


class Trie {
    static class TrieNode{
        final int ALPHABET_SIZE = 26;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord = false;
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode tmp = root;
        for (char i : word.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                tmp.children[i-'a'] = new TrieNode();
            }
            tmp = tmp.children[i-'a'];
        }
        tmp.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode tmp = root;
        for (char i : word.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                return false;
            }
            tmp = tmp.children[i-'a'];
        }
        return tmp.isEndOfWord ? true : false;
    }

    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (char i : prefix.toCharArray()) {
            if (tmp.children[i-'a'] == null) {
                return false;
            }
            tmp = tmp.children[i-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}


