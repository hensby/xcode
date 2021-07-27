package Amazon_onsite;


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

//208. Implement Trie (Prefix Tree)
//        A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
//
//        Implement the Trie class:
//
//        Trie() Initializes the trie object.
//        void insert(String word) Inserts the string word into the trie.
//        boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
//        boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
//
//
//        Example 1:
//
//        Input
//        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//        Output
//        [null, null, true, false, true, null, true]
//
//        Explanation
//        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.search("apple");   // return True
//        trie.search("app");     // return False
//        trie.startsWith("app"); // return True
//        trie.insert("app");
//        trie.search("app");     // return True
