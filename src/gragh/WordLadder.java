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

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord,endWord,wordList));

    }
}
