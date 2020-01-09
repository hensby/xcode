package stringAndBucket;

import java.util.Objects;

public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {
        RLE r = new RLE(S);
        int ans = 0;

        for (String word : words) {
            RLE w = new RLE(word);
            System.out.println(w.key);
            if (!Objects.equals(r.key, w.key)) {  //prevent none
                continue;
            }
            int i = 0;
            for (; i < r.counts.size(); ++i) {
                int c1 = r.counts.get(i);
                int c2 = w.counts.get(i);
                if ((c1 < 3 && c1 != c2) || c1 < c2) {
                    break;
                }
            }
            if (i == r.counts.size()) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String S = "heeellooo";
        String[] words = new String[]{"hello", "hi", "helo"};
        ExpressiveWords expressiveWords = new ExpressiveWords();
        System.out.println(expressiveWords.expressiveWords(S, words));
    }

}
