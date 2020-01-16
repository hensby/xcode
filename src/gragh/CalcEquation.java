package gragh;

import java.util.*;

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> numMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String[] str = equations.get(i).toArray(new String[0]);
            numMap.computeIfAbsent(str[0], k -> new HashMap<>()).put(str[1], values[i]);
            numMap.computeIfAbsent(str[1], k -> new HashMap<>()).put(str[0], 1.0 / values[i]);
        }
        System.out.println("numMap: " + numMap);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String[] query = queries.get(i).toArray(new String[0]);
            Double division = handleQuery(query[0], query[1], numMap, new HashSet<>());
            result[i] = (division != null) ? division : -1.0;
        }
        return result;
    }

    private Double handleQuery(String numerator, String denominator, Map<String, Map<String, Double>> numMap,
                               Set<String> visitedSet) {
        System.out.println("handle " + numerator + " " + denominator + visitedSet);
        String visitKey = numerator + ":" + denominator;    //分子，分母
        System.out.println("visitedSet: " + visitedSet);
        if (visitedSet.contains(visitKey)) return null;
        if (!numMap.containsKey(numerator) || !numMap.containsKey(denominator)) return null;
        if (numerator.equals(denominator)) return 1.0;

        Map<String, Double> denomMap = numMap.get(numerator);
        System.out.println("denomMap: " + denomMap);
        visitedSet.add(visitKey);
        for (Map.Entry<String, Double> entry : denomMap.entrySet()) {
            Double res = handleQuery(entry.getKey(), denominator, numMap, visitedSet);
            if (res != null) {
                return entry.getValue() * res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CalcEquation calcEquation = new CalcEquation();
        List<List<String>> equations = new ArrayList<>();
        List<String> equations1 = new ArrayList<>(Arrays.asList("a", "b"));
        List<String> equations2 = new ArrayList<>(Arrays.asList("b", "c"));
        equations.add(equations1);
        equations.add(equations2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queue = new ArrayList<>();
        List<String> queue1 = new ArrayList<>(Arrays.asList("a", "c"));
        List<String> queue2 = new ArrayList<>(Arrays.asList("b", "a"));
        List<String> queue3 = new ArrayList<>(Arrays.asList("a", "e"));
        List<String> queue4 = new ArrayList<>(Arrays.asList("a", "a"));
        List<String> queue5 = new ArrayList<>(Arrays.asList("x", "x"));
        queue.add(queue1);
        queue.add(queue2);
        queue.add(queue3);
        queue.add(queue4);
        queue.add(queue5);
        double[] res = calcEquation.calcEquation(equations, values, queue);
        for (double i : res) {
            System.out.print(i + " ");
        }
    }
}
//    Equations are given in the format A / B = k, where A and B are variables represented as strings,
//    and k is a real number (floating point number). Given some queries, return the answers.
//    If the answer does not exist, return -1.0.
//
//        Example:
//        Given a / b = 2.0, b / c = 3.0.
//        queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//        return [6.0, 0.5, -1.0, 1.0, -1.0 ].
//
//        The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
//        where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
//
//        According to the example above:
//
//        equations = [ ["a", "b"], ["b", "c"] ],
//        values = [2.0, 3.0],
//        queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

