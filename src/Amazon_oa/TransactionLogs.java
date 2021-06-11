package Amazon_oa;

import java.util.*;

public class TransactionLogs {

    static List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> map = new HashMap<>();
        for (String logLine : logs) {
            String[] log = logLine.split(" ");
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            if (!log[0].equals(log[1])) {
                map.put(log[1], map.getOrDefault(log[1], 0) + 1);
            }
        }

        List<String> userIds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) {
                userIds.add(entry.getKey());
            }
        }

        userIds.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });

        return userIds;
    }

    static List<String> processLogs1(List<String> logs, int threshold) {
        if (logs == null || logs.size() == 0 || threshold == 0) return null;
        Map<String, Integer> freqMap = new HashMap<>();
        for (String log: logs) {
            String[] logArr = log.split(" ");
            freqMap.put(logArr[0], freqMap.getOrDefault(logArr[0], 0) + 1);
            if (!logArr[0].equals(logArr[1])) {
                freqMap.put(logArr[1], freqMap.getOrDefault(logArr[1], 0) + 1);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() >= threshold) {
                res.add(entry.getKey());
            }
        }

        Collections.sort(res);
        return res;
    }



    public static void main(String[] args) {
        List<String> input = new ArrayList() {{
            add("345366 89921 45");
            add("029323 38239 23");
            add("38239 345366 15");
            add("029323 38239 77");
            add("345366 38239 23");
            add("029323 345366 13");
            add("38239 38239 23");
        }};

        processLogs(input, 2).forEach(System.out::println);
        processLogs1(input, 2).forEach(System.out::println);

    }
}


//    A Company parses logs of online store user transactions/activity to flag fraudulent activity.
//
//        The log file is represented as an Array of arrays. The arrays consist of the following data:
//
//        [ <# of transactions>]
//
//        For example:
//
//        [345366 89921 45]
//
//        Note: the data is space delimited
//
//        So, the log data would look like:
//
//        [
//        [345366 89921 45],
//        [029323 38239 23]
//        ...
//        ]
//        Write a function to parse the log data to find distinct users that meet or cross a certain threshold.
//
//        The function will take in 2 inputs:
//        logData: Log data in form an array of arrays
//
//        threshold: threshold as an integer
//
//        Output:
//        It should be an array of userids that are sorted.
//
//        If same userid appears in the transaction as userid1 and userid2, it should count as one occurrence, not two.
//
//        Example:
//        Input:
//        logData:
//
//        [
//        [345366 89921 45],
//        [029323 38239 23],
//        [38239 345366 15],
//        [029323 38239 77],
//        [345366 38239 23],
//        [029323 345366 13],
//        [38239 38239 23]
//        ...
//        ]
//        threshold: 3
//
//        Output: [345366 , 38239, 029323]
//        Explanation:
//        Given the following counts of userids, there are only 3 userids that meet or exceed the threshold of 3.
//
//        345366 -4 , 38239 -5, 029323-3, 89921-1
