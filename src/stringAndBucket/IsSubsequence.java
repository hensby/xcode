package stringAndBucket;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar, prev);
            if (prev == -1) {
                return false;
            }
            prev++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s, t));
    }
}
