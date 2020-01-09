package stringAndBucket;


import java.util.*;

/**
 Design two APIs
 tradeStocks(String ticker, int volume)  if there is a existed stock, add the volume on top of that
 getTopN(int N)  Get top N volume of stocks

 "AMZN", 2
 "GOOG", 3
 "MSFT", 4

 getTop(1) -> MSFT
 getTop(2) -> MSFT, GOOG

 "AMZN", 1

 --------------------------
 accumulative


 "AMZN", 3
 "GOOG", 3
 "MSFT", 4

 getTop(2) -> MSFT, AMZN


 --------------------------
 "GOOG", 2

 --------------------------

 "AMZN", 3
 "GOOG", 5
 "MSFT", 4

 getTop(2) -> GOOG, MSFT
 */
public class TradeStock {

    public static void main(String[] args) {
        Solution bruteforce = new BruteForce();
        test(bruteforce);
        Solution bucketSolution = new BucketSolution();
        test(bucketSolution);
    }

    public static void test(Solution solution) {
        solution.tradeStock("GOOGLE", 10);
        solution.tradeStock("Amazon", 15);
        solution.tradeStock("FACEBOOK", 30);
        solution.tradeStock("AIRBNB", 15);
        solution.tradeStock("GOOGLE", 25);

        // Google 35 FACEBOOK 30 AIRBNB 15
        List<String> answer = new ArrayList<>();
        answer.addAll(Arrays.asList(new String[] { "GOOGLE 35", "FACEBOOK 30", "AIRBNB 15" }));
        List<String> result = solution.getTopN(3);
        testLog(result.size() == answer.size());
        testLog(compareTwoList(answer, result));

        solution = new BucketSolution();
        solution.tradeStock("GOOGLE", 10);
        solution.tradeStock("AMAZON", 10);
        solution.tradeStock("FACEBOOK", 10);
        solution.tradeStock("AIRBNB", 10);

        // AIRBNB 10, AMAZON 10, FACEBOOK 10 GOOGLE 10
        answer.clear();
        answer.addAll(Arrays.asList(new String[] { "AIRBNB 10", "AMAZON 10", "FACEBOOK 10", "GOOGLE 10" }));
        result = solution.getTopN(6);
        resultLog(result.toString(), "getTopN(6)");
        testLog(result.size() == answer.size());
        testLog(compareTwoList(answer, result));
        answer.clear();
        answer.addAll(Arrays.asList(new String[] { "GOOGLE 20", "AIRBNB 10", "AMAZON 10", "FACEBOOK 10" }));
        solution.tradeStock("GOOGLE", 10);
        result = solution.getTopN(6);
        resultLog(result.toString(), "tradeStock(\"GOOGLE\", 10);");
        testLog(result.size() == answer.size());
        testLog(compareTwoList(answer, result));
        answer.clear();
        solution.tradeStock("AIRBNB", 20);
        answer.addAll(Arrays.asList(new String[] { "AIRBNB 30", "GOOGLE 20" }));
        result = solution.getTopN(2);
        resultLog(result.toString(), "tradeStock(\"AIRBNB\", 20)");
        testLog(answer.size() == result.size());
        testLog(compareTwoList(answer, result));

    }

    private static void testLog(boolean isRight) {
        if (isRight) {
            System.out.println("Accept");
        } else {
            System.out.println("Wrong answer");
            System.exit(0);
        }
    }

    private static void resultLog (String result, String title) {
        if (!result.isEmpty()) {
            System.out.println(title +"： " + result);
        } else {
            System.out.println();
            System.exit(0);
        }
    }

    private static boolean compareTwoList(List<String> answer, List<String> result) {
        for (int i = 0; i < result.size(); i++) {
            if (!answer.get(i).equals(result.get(i))) {
                return false;
            }
        }
        return true;
    }

    // interface for two different solutions
    interface Solution {
        void tradeStock(String ticker, int volumn);

        List<String> getTopN(int n);
    }

    // Solution 1
    static class BruteForce implements Solution {
        Map<String, Integer> trades = new HashMap<>();


        public void tradeStock(String ticker, int volume) {
            int totalvolume = trades.getOrDefault(ticker, 0) + volume;
            trades.put(ticker, totalvolume);

        }

        public List<String> getTopN(int n) {
            // key is volume, value is list of stickers
            Map<Integer, List<String>> m = new TreeMap<>(Collections.reverseOrder());
            // List can be replaced with TreeSet

            for (Map.Entry<String, Integer> entry : this.trades.entrySet()) {
                String ticker = entry.getKey();
                int v = entry.getValue();
                m.computeIfAbsent(v, k -> new ArrayList<>()).add(ticker);
            }

            List<String> result = new ArrayList<>();

            for (Map.Entry<Integer, List<String>> entry : m.entrySet()) {
                int v = entry.getKey();
                List<String> l = entry.getValue();
                Collections.sort(l);
                for (String t : l) {
                    if (--n < 0) {
                        return result;
                    }
                    result.add(t + " " + v);
                }
            }
            return result;
        }

    }

    // Solution 2
    static class BucketSolution implements Solution {
        // Bucket head(min) > a.count > b.count > c
        // Key is the stock name, value is the stock volume
        Map<String, Integer> trades;
        // Key is the volume, value is the bucket with volume as count
        Map<Integer, Bucket> buckets;
        // Head means the minimum count
        private Bucket head;
        // Tail means maximum count
        private Bucket tail;

        // head(min) <-> BucketA <-> BucketB <-> tail(max)
        public BucketSolution() {
            this.head = new Bucket(Integer.MIN_VALUE);
            this.tail = new Bucket(Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
            // head -> head.next -> ... -> tail.pre -> tail
            // MIN_VALUE -> smallest -> ... biggest -> MAX_VALUE
            trades = new HashMap<>();
            buckets = new HashMap<>();
        }

        /**
         * Best case O(1) Average and Worst O(N + LogM) where M is the number of stocks
         * in a bucket
         */
        public void tradeStock(String ticker, int volume) {
            int oldVolume = trades.getOrDefault(ticker, 0);
            int newVolume = oldVolume + volume; // Get the total volume
            trades.put(ticker, newVolume);
            if (oldVolume != 0) {
                // If the stock name has been put in before, we remove it's name from it's
                // previous volume bucket
                buckets.get(oldVolume).stockNames.remove(ticker);
            }
            Bucket newVolumeBucket = buckets.get(newVolume);
            // If there is no new volume bucket existed
            if (newVolumeBucket == null) {
                newVolumeBucket = new Bucket(newVolume);
                insertNewBucket(newVolumeBucket, oldVolume != 0 ?
                        // Starts from the original volume bucket to find the place to insert
                        buckets.get(oldVolume) :
                        // Do a linear search if this is a new stock and a new volume
                        head);
            }
            // Remove if the old volume bucket has no stocks in there
            if (oldVolume != 0 && buckets.get(oldVolume).stockNames.isEmpty()) {
                buckets.remove(oldVolume);
            }
            // Add the ticker into the bucket - log(k) runtime, k is size of treeset
            newVolumeBucket.stockNames.add(ticker);
        }

        // Worst
        private void insertNewBucket(Bucket newBucket, Bucket startBucket) {
            // Traverse from start bucket position
            Bucket bigger = startBucket;
            while (bigger.count < newBucket.count) {
                bigger = bigger.next;
            }
            // bigger.count > newBucket.count
            Bucket smaller = bigger.pre;
            // head <-> ... <-> smaller <-> newBucket <-> bigger <-> ... <-> tail
            // adjust bucket
            newBucket.pre = smaller;
            newBucket.next = bigger;

            // adjust smaller
            smaller.next = newBucket;

            // adjust bigger
            bigger.pre = newBucket;

            // Put this bucket in the map
            buckets.put(newBucket.count, newBucket);
        }

        /*
         * returning top N O(n)
         */
        public List<String> getTopN(int n) {
            Bucket currBucket = tail.pre; // The first bucket will be the one right before tail
            List<String> res = new ArrayList<>();
            while (currBucket != this.head && res.size() < n) {
                for (String stockName : currBucket.stockNames) {
                    res.add(stockName + " " + this.trades.get(stockName));
                    if (res.size() == n) {
                        break;
                    }
                }
                currBucket = currBucket.pre;
            }
            return res;
        }

        // Bucket class
        static class Bucket {
            int count;
            TreeSet<String> stockNames; // Insert takes LogN time wise
            Bucket next;
            Bucket pre;

            public Bucket(int count) {
                this.count = count;
                this.stockNames = new TreeSet<>();
            }
        }
    }
}
