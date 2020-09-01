package Amazon_oa;

import java.util.*;

public class TopKFrequentlyMentionedKeywords {
    public static List<String> freqWords(int k, String[] keywords, String[] reviews) {
        Set<String> keywordsSet = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();
        for(String s: reviews) {
            Set<String> words = new HashSet<>(Arrays.asList(s.split(" ")));
            for(String w: words) {
                if(keywordsSet.contains(w)) {
                    map.put(w, map.getOrDefault(w,0) + 1);
                }
            }
        }
        System.out.println(map);
        PriorityQueue<String> pq = new PriorityQueue<>((l1, l2) -> map.get(l2) - map.get(l1));
        pq.addAll(map.keySet());
        List<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }

    public static List<String> freqWords1(int k,String[] keywords,String[] words){
        Map<String,Integer> count= new HashMap<>();
        List<String> keywordsList= Arrays.asList(keywords);
        for(String word:words){
            Set<String> wordSet = new HashSet<>(Arrays.asList(word.split("\\s+")));
            for(String s: wordSet){
                if(keywordsList.contains(s)){
                    count.put(s,count.getOrDefault(s,0)+1);
                }
            }
        }
        System.out.println(count);
        List<String> ls = new ArrayList<>(count.keySet());
        Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));

        return ls.subList(0,k);
    }


    public static void main(String[] args) {
        int k = 2;
        String[] keywords = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = new String[]{
        "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};
        System.out.println(freqWords1(k, keywords, reviews));
    }
}

//    Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
//      https://leetcode.com/discuss/interview-question/542597/
//        The comparison of strings is case-insensitive.
//        Multiple occurances of a keyword in a review should be considred as a single mention.
//        If keywords are mentioned an equal number of times in reviews, sort alphabetically.
//
//        Example 1:
//
//        Input:
//        k = 2
//        keywords = ["anacell", "cetracular", "betacellular"]
//        reviews = [
//        "Anacell provides the best services in the city",
//        "betacellular has awesome services",
//        "Best services provided by anacell, everyone should use anacell",
//        ]
//
//        Output:
//        ["anacell", "betacellular"]
//
//        Explanation:
//        "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
//        Example 2:
//
//        Input:
//        k = 2
//        keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
//        reviews = [
//        "I love anacell Best services; Best services provided by anacell",
//        "betacellular has great services",
//        "deltacellular provides much better services than betacellular",
//        "cetracular is worse than anacell",
//        "Betacellular is better than deltacellular.",
//        ]
//
//        Output:
//        ["betacellular", "anacell"]
//
//        Explanation:
//        "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.