package Amazon_onsite;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

    static class Visit {
        String username;
        int timestamp;
        String website;
        public Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }

        @Override
        public String toString() {
            return "Visit{" +
                    "username='" + username + '\'' +
                    ", timestamp=" + timestamp +
                    ", website='" + website + '\'' +
                    '}';
        }
    }

    Map<List<String>, Integer> resMap = new HashMap<>();

    public List<String> mostVisitedPattern(String[] usernames, int[] timestamps, String[] websites) {
        if (usernames.length != timestamps.length || usernames.length != websites.length) return null;
        Map<String, List<Visit>> behaviors = new HashMap<>();
        int len = usernames.length;
        for (int i = 0; i < len; i++) {
            if (!behaviors.containsKey(usernames[i])) {
                behaviors.put(usernames[i], new ArrayList<>());
            }
            behaviors.get(usernames[i]).add(new Visit(usernames[i], timestamps[i], websites[i]));
        }
        System.out.println(behaviors);

        for (String key: behaviors.keySet()) {
            behaviors.get(key).sort((v1, v2) -> v1.timestamp - v2.timestamp);
            boolean[] isVisit = new boolean[behaviors.get(key).size()];
            dfs(0, isVisit, behaviors.get(key), new ArrayList<>());
        }
        System.out.println(resMap);

        List<List<String>> result = new ArrayList<>();
        int max = 0;
        for (List<String> key: resMap.keySet()) {
            if(max == resMap.get(key)) {
                result.add(key);
            } else if (max < resMap.get(key)) {
                result = new ArrayList<>();
                result.add(key);
                max = resMap.get(key);
            }
        }

        if (result.size() == 0) return null;
        result.sort((r1, r2) -> r1.get(0).compareTo(r2.get(0)) == 0? r1.get(0).compareTo(r2.get(0)): r1.get(1).compareTo(r2.get(1)) == 0? r1.get(1).compareTo(r2.get(1)): r1.get(2).compareTo(r2.get(2)));

        return result.get(0);
    }

    public void dfs(int index, boolean[] isVisit, List<Visit> behaviors, List<String> tmpRes) {
        if (tmpRes.size() == 3) {
            resMap.put(new ArrayList<>(tmpRes), resMap.getOrDefault(tmpRes, 0) + 1);
        }
        int len = behaviors.size();
        for (int i = index; i < len; i++) {
            if (!isVisit[i]) {
                tmpRes.add(behaviors.get(i).website);
                isVisit[i] = true;
                dfs(i + 1, isVisit, behaviors, tmpRes);
                tmpRes.remove(tmpRes.size() - 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        AnalyzeUserWebsiteVisitPattern at = new AnalyzeUserWebsiteVisitPattern();
        String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[] {1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[] {"home","about","career","home","cart","maps","home","home","about","career"};
        System.out.println(at.mostVisitedPattern(username, timestamp, website));
    }
}
//LeetCode 1152. Analyze User Website Visit Pattern
//        原题链接在这里：https://leetcode.com/problems/analyze-user-website-visit-pattern/
//
//        题目：
//
//        We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
//
//        A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
//
//        Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
//
//        Example 1:
//
//        Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
//        Output: ["home","about","career"]
//        Explanation:
//        The tuples in this example are:
//        ["joe", 1, "home"]
//        ["joe", 2, "about"]
//        ["joe", 3, "career"]
//        ["james", 4, "home"]
//        ["james", 5, "cart"]
//        ["james", 6, "maps"]
//        ["james", 7, "home"]
//        ["mary", 8, "home"]
//        ["mary", 9, "about"]
//        ["mary", 10, "career"]
//        The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
//        The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
//        The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
//        The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
//        The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
//        Note:
//
//        3 <= N = username.length = timestamp.length = website.length <= 50
//        1 <= username[i].length <= 10
//        0 <= timestamp[i] <= 10^9
//        1 <= website[i].length <= 10
//        Both username[i] and website[i] contain only lowercase characters.
//        It is guaranteed that there is at least one user who visited at least 3 websites.
//        No user visits two websites at the same time.
//        题解：
//
//        Try to get the website sequence visted by most different users. sequence here means chronological order.
//
//        First sort the data by timestamp.
//
//        And put user and corresponding websites into HashMap<String, List<String>>.
//
//        For each user, find all its combination of 3 websites.
//
//        And each sequence within this combination, check its count of different user. If count is higher or lexicographically smaller, update the max sequence.
//
//        The max sequence is the result.
//
//        Time Complexity: O(n ^ 3). n = username.length. sort takes O(nlogn). getCom takes O(n ^ 3).
//
//        Space: O(n ^ 3).
//
