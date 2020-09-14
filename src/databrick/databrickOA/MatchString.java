package databrick.databrickOA;

public class MatchString {
    //第一题： 题目比较简单，给两个input String t 和 s, 让你数有多少个match。match的条件是 t的index i, i + 2, i + 4 凑成一起的新的String 正好等于s
    //比如input s = "axcxdaycyd"  t = "acd" output = 2 因为"axcxd" ”aycyd“ 能够match t
    public static int matchString(String s, String t) {
        if(s.length() < t.length() * 2 + 1) return 0;
        int res = 0;
        int sLen = s.length(), tLen = t.length(); // 10, 3
        for(int i = 0; i <= sLen - tLen * 2 + 1; i++) {
            if(s.charAt(i) == t.charAt(0)){
                boolean tmp = true;
                for(int j = 0; j < tLen; j++) {
                    if(s.charAt(j * 2) != t.charAt(j)) {
                        tmp = false;
                        break;
                    }
                }
                if(tmp == true) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "axcxdaycyd", t = "acd";
        System.out.println(matchString(s, t));
    }
}
