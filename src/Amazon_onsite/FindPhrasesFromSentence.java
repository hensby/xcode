package Amazon_onsite;

import java.util.*;

public class FindPhrasesFromSentence {

    public static class TireNode {
        Map<String, TireNode> children = new HashMap<>();
        boolean isEnd;
    }
    TireNode root;
    public List<String> findPhrases(List<String> phrases, String s) {
        Set<String> res = new HashSet<>();
        this.root = new TireNode();
        for (String phrase: phrases) {
            TireNode cur = root;
            String[] sSubList = phrase.split(" ");
            for (String tmpS: sSubList) {

                if (!cur.children.containsKey(tmpS)) {
                    cur.children.put(tmpS, new TireNode());
                }
                cur = cur.children.get(tmpS);
            }
            cur.isEnd = true;
        }

        String[] sList = s.split(" ");
        for (int i = 0; i < sList.length; i++) {
            TireNode cur = root;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < sList.length; j++) {
                if (cur.children.get(sList[j]) != null) {
                    if (sb.length() != 0) {
                        sb.append(" ");
                    }
                    sb.append(sList[j]);
                    if (cur.children.get(sList[j]).isEnd) {
                        res.add(sb.toString());
                    }
                    cur = cur.children.get(sList[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<String> phrases = Arrays.asList("have", "have a good", "have a good morning", "and evening", "catfish");
        String s = "have a good morning and evening";
        FindPhrasesFromSentence findPhrases = new FindPhrasesFromSentence();
        System.out.println(findPhrases.findPhrases(phrases, s));
    }
}
//    给出一组 string phrases， 然后给你另一个string S。 返回所有在 phrases 中的 S的 substring。没有想到什么特别好的算法， 给了一个naive的hashset 解法 和一个trie 解法（都是O(n2), 我写了trie）。 感觉天竺大叔反应不太正面， 应该是挂了。
//        感觉描述的不是很清楚， 给个例子吧。
//        phrases ：["have", "have a good", "have a good morning", "and evening", "catfish"],
//        S :  "Have a good morning and evening"
//        results 应该是‍‍‍‍‍‌‍‍‍‌‌‌‍‍‍‌‌‍‌ ["have", "have a good", "have a good mining", "and evening"]