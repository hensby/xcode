package greedy;

public class IsSubsequence {
//    public static  boolean isSubsequence(String s, String t) {
//        if(s.length() > t.length()) return false;
//        int sIndex = 0, tIndex = 0;
//        while(sIndex < s.length() && tIndex < t.length()) {
//            System.out.println(sIndex + " " + tIndex);
//            if(sIndex == s.length() - 1) return true;
//            if(s.charAt(sIndex) == t.charAt(tIndex)) sIndex++;
//            tIndex++;
//        }
//        return false;
//    }
    public static boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
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
        System.out.println(isSubsequence("axc","ahbgdc"));
//        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
