package gragh;

import java.util.*;

public class CurrencyExchange {

    /**
     * Given a file containing ratios between labels and query file containing pair of labels, find the ratio between each label pair (write it to an output file)
     * <p>
     * <p>
     * Input file example:
     * <p>
     * Source		Ratio		Destination
     * GBP		0.69		USD
     * Yard		1.09		Meter
     * EUR		0.0077		YEN
     * YEN		167.75		GBP
     * <p>
     * <p>
     * Query file example:
     * <p>
     * Source		Destination
     * EUR		USD
     * Meter		Yard
     * <p>
     * Output file example:
     * <p>
     * Source		Ratio		Destination
     * EUR		0.89		USD
     * Meter		0.91		Yard
     * <p>
     * <p>
     * Write a program that produces a list of ratio records using the provided ratio records and queries.
     */
    private static class Ratio {
        String num;
        String denom;
        double ratio;

        public Ratio(String num, String denom, double ratio) {
            this.num = num;
            this.denom = denom;
            this.ratio = ratio;
        }
    }

    private static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public double[] queryRatios(List<Ratio> ratios, List<Pair> queries) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();
        for (Ratio ratio : ratios) {
            adjList.computeIfAbsent(ratio.num, k -> new HashMap<>()).put(ratio.denom, ratio.ratio);
            adjList.computeIfAbsent(ratio.denom, k -> new HashMap<>()).put(ratio.num, 1.0 / ratio.ratio);
        }
        int queueLength = queries.size();
        double[] result = new double[queueLength];
        Map<String, Double> memorization = new HashMap<>();
        for (int i = 0; i < queueLength; i++) {
            Pair query = queries.get(i);
            result[i] = processQuery(query.first, query.second, adjList, memorization);
        }
        return result;


    }

    private static final double EPSILON = 0.00001;

    // Map<String, Double> memorization, Set<String> visitedSet
    // -1.0 not possible
    // -2.0 as visited
    private double processQuery(String num, String denom, Map<String, Map<String, Double>> adjList,
                                Map<String, Double> memorization) {

        System.out.println("memorization " + memorization);
        String key = num + ":" + denom;
        Double res = memorization.get(key);
        System.out.println(key);
        if (res != null) return res;
        if (!adjList.containsKey(num) || !adjList.containsKey(denom)) return -1.0;
        if (num.equals(denom)) return 1.0;

        Map<String, Double> numMap = adjList.get(num);
        Double d = numMap.get(denom);
        if (d != null) {
            memorization.put(key, d);
            return d;
        }

        memorization.put(key, -2.0);
        boolean hasVisited = false;
        for (Map.Entry<String, Double> entry : numMap.entrySet()) {
            double ans = processQuery(entry.getKey(), denom, adjList, memorization);
            if (ans + 2.0 < EPSILON) {
                hasVisited = true;
            }
            if (ans > 0) {
                double v = entry.getValue() * ans;
                memorization.put(key, v);
                return v;
            }
        }

        if (hasVisited) {
            memorization.remove(key);
        } else {
            // if there is no direction back to num
            memorization.put(key, -1.0);
        }

        return -1.0;
    }

    public static void main(String[] args) {
        CurrencyExchange solution = new CurrencyExchange();
        List<Ratio> ratios = new ArrayList<>() {{
            add(new Ratio("USD", "GBP", 0.69));
            add(new Ratio("YEN", "EUR", 0.0077));
            add(new Ratio("GBP", "YEN", 167.75));
            add(new Ratio("USD", "RP", 212.02));
            add(new Ratio("Yard", "Meter", 1.09));
        }};
        List<Pair> queries = new ArrayList<>() {{
            add(new Pair("USD", "EUR"));
			add(new Pair("YEN", "YEN"));
			add(new Pair("Meter", "Yard"));
			add(new Pair("Meter", "RP")); //should return -1.0
			add(new Pair("Yard", "RP"));  //should return -1.0
        }};

//        List<Ratio> ratios = Arrays.asList(
//                new Ratio("a", "b", 1.0), new Ratio("a", "c", 2.0),
//                new Ratio("a", "d", 3.0), new Ratio("a", "e", 4.0),
//                new Ratio("a", "f", 5.0), new Ratio("a", "g", 6.0),
//                new Ratio("a", "h", 7.0), new Ratio("a", "i", 8.0),
//                new Ratio("a", "j", 9.0), new Ratio("a", "k", 10.0),
//                new Ratio("a", "l", 11.0), new Ratio("a", "aa", 1.0),
//                new Ratio("a", "aaa", 1.0), new Ratio("a", "aaaa", 1.0),
//                new Ratio("a", "aaaa", 1.0), new Ratio("a", "bb", 1.0),
//                new Ratio("a", "bbb", 3.0), new Ratio("a", "ff", 5.0));
//        List<Pair> queries = Arrays.asList(new Pair("d", "f"), new Pair("e", "g"), new Pair("e", "k"),
//                new Pair("h", "a"), new Pair("aaa", "k"));
        double[] res = solution.queryRatios(ratios, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.print(queries.get(i).first + " " + queries.get(i).second + " ");
            System.out.println(res[i]);
        }

    }

}

