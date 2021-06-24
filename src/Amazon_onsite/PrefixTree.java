package Amazon_onsite;

public class PrefixTree {

    /** Initialize your data structure here. */
    int alphabetSize = 26;
    class PrefixNode {
        PrefixNode[] children = new PrefixNode[alphabetSize];
        boolean isEnd;
    }
    PrefixNode root;
    public PrefixTree() {
        this.root = new PrefixNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (null == word || word.length() == 0) return;
        PrefixNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            PrefixNode childNode = cur.children[index];
            if (childNode == null) {
                childNode = new PrefixNode();
                cur.children[index] = childNode;
            }
            if (i == word.length() - 1) {
                childNode.isEnd = true;
            }
            cur = cur.children[index];
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (null == word || word.length() == 0) return false;
        PrefixNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (null == prefix || prefix.length() == 0) return false;
        PrefixNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();
        trie.insert("apple");
        trie.insert("whc");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

}
//      208. Implement Trie (Prefix Tree)
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