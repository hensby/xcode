package gragh;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int res=0;
        while(!q.isEmpty()){
            int len=q.size();
            res++;
            while(len-->0){
                String s=q.poll();
                List<String> list=getneighbor(s, set);
                for(String string:list){
                    if(string.equals(endWord)) return 1+res;
                    q.offer(string);
                }
            }
        }
        return 0;
    }
    public List<String> getneighbor(String s, Set<String> set){
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
        return list;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord,endWord,wordList));

    }
}
