package robinhood;

public class cutString {
//    将一个string里的数，按最大长度为k分成若干组，将每组的数相加，直到最后string 长度小于等于k 返回最后的string。
//    比如string是“1111122222” k=3, 第一次分完得到 “3462”，长度大于k, 接着分，
//    第二次分 完得到“132”，返回string “132”。
    public static String curKString(String s, int k) {
        char[] sChar = s.toCharArray();
        System.out.println(sChar);
        int len = s.length(), index = 0;
        StringBuilder res = new StringBuilder();
        while(index < len) {
            int tmp = 0;
            for(int i = 0; i < k && index + i < len; i++) {
                int intNum = sChar[index + i] - '0';
                tmp += intNum;
                System.out.println(tmp);
            }
            res.append(String.valueOf(tmp));
            System.out.println(index);
            index += k;
        }
        System.out.println(res);
        if(res.length() > k) {
            return curKString(res.toString(), k);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(curKString("1111122222", 3));
    }
}
