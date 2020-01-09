package stringAndBucket;

import java.util.*;
import java.util.stream.Collectors;


public class SubsequenceOfFileNames {


    public static void main(String[] args) {
        SubsequenceOfFileNames subsequenceOfFileNames = new SubsequenceOfFileNames();
        System.out.println(subsequenceOfFileNames.isSubsequence("Mava", "MyJavaClass.java"));
        System.out.println(subsequenceOfFileNames.isSubsequence("Mav", "Maaaaaavvvv"));
        System.out.println(subsequenceOfFileNames.isSubsequence("Ma", "Maaaaaabcdefga"));
        System.out.println(subsequenceOfFileNames.isSubsequence("Ma", "abcdefg"));

        System.out.println(subsequenceOfFileNames.getFiles("Ma"));
        //System.out.println("cache:" + subsequenceOfFileNames.cache);
        System.out.println(subsequenceOfFileNames.getFiles("Mav"));
        //System.out.println("cache:" + subsequenceOfFileNames.cache);
        System.out.println(subsequenceOfFileNames.getFiles("Mava"));
        //System.out.println("cache:" + subsequenceOfFileNames.cache);
    }

    /**
     * 1. Some IDEs let you type a non-contiguous substring of the file name in
     * order to search and open a file. Write a method that takes a pattern and a
     * filename and returns whether or not the pattern is a non-contiguous substring
     * of the filename. For instance, pattern "Mav" is a non-contiguous substring of
     * "MyJavaClass.java". “MM” is not.
     */

    // ignore case
    boolean isSubsequence(String pattern, String fileName) {
        if (fileName.length() < pattern.length()) {
            return false;
        }

        int prev = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char tempChar = pattern.charAt(i);
            prev = fileName.indexOf(tempChar, prev); // prev is the fromIndex
            if (prev == -1) {
                return false;
            }

            prev++;
        }

        return true;
    }

    /**
     * 2.Usually the IDE will let you type and when you pause, it will display the
     * current list of matches. Pretend you're working on a team for this feature.
     * Someone else is in charge of UI and collecting the current pattern whenever
     * the user pauses. Write a utility that will take the pattern and return a list
     * of the current matches. For example, if the user input is:
     * Ma<pause>v<pause>a<pause> 1st call: “Ma” 2nd call: “Mav” 3rd call: “Mava”
     */

    // Available util function
    static Iterable<String> getAllFiles() {
        List<String> files = new ArrayList<>();
        files.add("MyJavaClass.java"); // can match Ma/Mav/Mava
        files.add("Maaaaaa"); // can match Ma
        files.add("Maaaaaavvvv"); // can match Mav
        files.add("abcdefg"); // no match
        return files;
    }

    private static class SearchResult {
        String fileName;
        int nextIndex;

        public SearchResult(String fileName, int nextIndex) {
            this.fileName = fileName;
            this.nextIndex = nextIndex;
        }

        @Override
        public String toString() {
            return "SearchResult{" +
                    "fileName='" + fileName + '\'' +
                    ", nextIndex=" + nextIndex +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(fileName, nextIndex);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SearchResult that = (SearchResult) o;
            return nextIndex == that.nextIndex &&
                    Objects.equals(fileName, that.fileName);
        }
    }

    // another way: caching, save the search result
    private Map<String, List<SearchResult>> cache;

    public SubsequenceOfFileNames() {
        this.cache = new HashMap<>();
    }

    public List<String> getFiles(String pattern) {
        List<SearchResult> l = this.cache.get(pattern);
        if (l != null) {
            return l.stream().map(f -> f.fileName).collect(Collectors.toList());
        }
        // MAA => MA => M
        // use longer one
        List<SearchResult> results;
        for (int i = pattern.length() - 1; i > 0; i--) {
            String pre = pattern.substring(0, i);
            l = this.cache.get(pre);
            if (l != null) {
                results = getSubsets(l, pattern.substring(i));
                cache.put(pattern, results);
                return results.stream().map(f -> f.fileName).collect(Collectors.toList());
            }
        }

        // cache miss
        results = getFromAllFiles(pattern);
        cache.put(pattern, results);
        return results.stream().map(f -> f.fileName).collect(Collectors.toList());
    }

    // for a cache miss
    private List<SearchResult> getFromAllFiles(String pattern) {
        Iterator<String> iterator = getAllFiles().iterator();
        List<SearchResult> res = new ArrayList<>();
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            int match = isSubsequence(pattern, fileName, 0);
            if (match >= 0) {
                res.add(new SearchResult(fileName, match));
            }
        }
        return res;
    }

    // String is the file Name, integer is the last index that matched
    private List<SearchResult> getSubsets(List<SearchResult> l, String pattern) {
        List<SearchResult> res = new ArrayList<>();
        for (SearchResult pair : l) {
            String fileName = pair.fileName;
            int index = pair.nextIndex;
            int match = isSubsequence(pattern, fileName, index);
            if (match >= 0) {
                res.add(new SearchResult(fileName, match));
            }
        }
        return res;
    }

    // isSubsequence -> index for last match + 1
    private int isSubsequence(String pattern, String fileName, int begIndex) {
        if (fileName.length() < pattern.length()) {
            return -1;
        }

        int prev = begIndex;
        for (int i = 0; i < pattern.length(); i++) {
            if (prev >= fileName.length()) {
                return -1;
            }
            char tempChar = pattern.charAt(i);
            prev = fileName.indexOf(tempChar, prev); // prev is the fromIndex
            if (prev == -1) {
                return -1;
            }

            prev++;
        }

        return prev;
    }
}
