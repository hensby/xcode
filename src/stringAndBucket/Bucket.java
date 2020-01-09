package stringAndBucket;

import java.util.LinkedHashSet;

public class Bucket {
    int count;
    LinkedHashSet<Integer> keySet;
    Bucket next;
    Bucket pre;

    public Bucket(int cnt) {
        this.count = cnt;
        this.keySet = new LinkedHashSet<>();
    }

}
