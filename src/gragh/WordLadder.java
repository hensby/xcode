package gragh;

import java.util.*;
//127

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord) || wordSet.contains(beginWord)) return 0;
        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.offer(beginWord);
        int res = 0;

        while (!wordQueue.isEmpty()) {
            int len=wordQueue.size();
            res++;
            while(len-->0){
                String s=wordQueue.poll();
                List<String> list=getNeighbor(s, wordSet);
                for(String string:list){
                    if(string.equals(endWord)) return 1+res;
                    wordQueue.offer(string);
                }
            }
        }
        return 0;
    }
    public List<String> getNeighbor(String s, Set<String> set){
        List<String> list=new ArrayList<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char tmp=ch[i];
            for(char c='a';c<='z';c++){
                if(c!=tmp){
                    ch[i]=c;
                    String s1=new String(ch);
                    if(set.contains(s1)){
                        list.add(s1);
                        set.remove(s1);
                    }
                }
            }
            ch[i]=tmp;
        }
        System.out.println(list);
        return list;
    }


    Set<String> wordSet;

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 0;
        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmpWord = queue.poll();
                List<String> tmpNeighbers = getNeighber1(tmpWord);
                for (String neighber: tmpNeighbers) {
                    if (neighber.equals(endWord)) return 1 + res;
                    queue.add(neighber);
                }
            }
        }
        return 0;
    }

    public List<String> getNeighber1(String word) {
        char[] wordCharArray = word.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordCharArray.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char tmpChar = wordCharArray[i];
                wordCharArray[i] = c;
                String neighber = new String(wordCharArray);
                if (wordSet.contains(neighber)) {
                    res.add(neighber);
                    wordSet.remove(neighber);
                }
                wordCharArray[i] = tmpChar;
            }
        }
        System.out.println("wordSet" + wordSet);
        return res;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog", "hmt");
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord,endWord,wordList));
        System.out.println(wordLadder.ladderLength1(beginWord,endWord,wordList));

    }
}
// getNeighber()
// bfs

//127. Word Ladder
//        A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//        Every adjacent pair of words differs by a single letter.
//        Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//        sk == endWord
//        Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
//
//        Example 1:
//
//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//        Output: 5
//        Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//        Example 2:
//
//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//        Output: 0
//        Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
//
//        Constraints:
//
//        1 <= beginWord.length <= 10
//        endWord.length == beginWord.length
//        1 <= wordList.length <= 5000
//        wordList[i].length == beginWord.length
//        beginWord, endWord, and wordList[i] consist of lowercase English letters.
//        beginWord != endWord
//        All the words in wordList are unique.