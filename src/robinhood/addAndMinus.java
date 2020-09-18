package robinhood;

public class addAndMinus {
    //给一个正整数，按减加的方式计算所有数位的和，比如 给的数是5334，输出的就是 1（5-3+3-4）。
    public static int addMinus(int a) {
        if(a < 10) return a;
        String s = String.valueOf(a);
        boolean flag = false;
        if(s.length() % 2 != 0) flag = true;
        return addAndMinusHelper(a, flag, 0);
    }

    public static int addAndMinusHelper(int a, boolean flag, int res) {
        if(flag) res += a % 10;
        else res -= a % 10;
        a = a / 10;
        if(a == 0) return res;
        else return addAndMinusHelper(a, !flag, res);
    }

    public static void main(String[] args) {
        System.out.println(addMinus(5334));
    }
}
