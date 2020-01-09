package stringAndBucket;

import java.util.ArrayList;
import java.util.List;

public class RLE {

    String key;
    List<Integer> counts;

    public RLE(String s) {
        StringBuffer sb = new StringBuffer();
        this.counts = new ArrayList<>();

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == s.length() - 1 || c!=s.charAt(i + 1)) {
                sb.append(c);
                this.counts.add(i - prev);
                prev = i;
            }
        }
        this.key = sb.toString();
    }
}
