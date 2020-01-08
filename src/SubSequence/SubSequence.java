package SubSequence;


import javax.swing.plaf.IconUIResource;

/**
 * strA: 'SDSD' strB: 'ADS'
 * 請問幾次能複製過去
 * 從strB上: S -> DS -> D 所以複製三次
 *
 * ADS + ADS + ADS = ADSADSADS
 */
public class SubSequence {
    public static int min(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (t == null || t.length() == 0) {
            return -1;
        }
        int res = 1;
        for (int indexT = 0, indexS = 0; indexS < s.length(); indexS++) {
            char cur = s.charAt(indexS);
            int find = indexOf(t, cur, indexT);
            System.out.println(find);
            if (find == -1) {
                return -1;
            }
            if (find < indexT) {
                res++;
            }

            indexT = find + 1;
        }
        return res;
    }

    private static int indexOf(String t, char c, int begIndex) {
        if (begIndex >= t.length()) begIndex = 0;
        int index = begIndex;
        System.out.println(index);
        do {
            if (t.charAt(index) == c) return index;
            if (++index == t.length()) {
                index = 0;
            }
        }while (index != begIndex);
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(indexOf("abcd", 'a', 0)); // 0
//        System.out.println(indexOf("abcd", 'a', 1)); // 0
//        System.out.println(indexOf("abcd", 'a', 2)); // 0
//        System.out.println(indexOf("abcd", 'a', 3)); // 0
//        System.out.println(indexOf("abcd", 'a', 4)); // 0
//        System.out.println(indexOf("abcd", 'e', 0)); // -1

        System.out.println(min("SDSD", "ADS")); // 3
//        System.out.println(min("SDS", "ADS")); // 2
//        System.out.println(min("SDT", "ADS")); // -1
//        System.out.println(min("", "ADS")); // 0
//        System.out.println(min("SDT", "")); // -1
//        System.out.println(min("", "")); // 0
//        System.out.println(min("aaaaaaaaaa", "xxxxxxaxxxxxxx")); // 10
//        System.out.println(min("aaaaaaaaaa", "xxxxxxaaxxxxxxx")); // 5
//        System.out.println(min("aaaaaaaaaa", "xxxxxxaxxaxxxxx")); // 5
//        System.out.println(min("aaaaaaaaaa", "axxxxxxxxxxxxxa")); // 5
    }
}