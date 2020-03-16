import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0 || words == null) return new ArrayList<String>();
        HashMap<String, Integer> count = new HashMap<>();
        List<String> wordsSet = new ArrayList<>();
        for (String i : words) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i , 1);
                wordsSet.add(i);
            }
        }
        Collections.sort(wordsSet, (w1, w2) -> count.get(w1).equals(count.get(w2))?
                w1.compareTo(w2): count.get(w2) - count.get(w1));


        return wordsSet.subList(0,k);
    }

    public static void main(String[] args) {
        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(words,3));
    }
}
// 692