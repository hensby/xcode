package robinhood;

public class booleanQueue {
    public String booleanDequeBit(int n, String[] oper) {

        if (n == 0) {

            return new String();

        }

        int res = 0;

        for (int i = 0; i < oper.length; i++) {

            if (oper[i].equals("L")) { //find smallest 0 --> 1

                int k = n;
                while (k > 0) {

                    int cur = (res >> (k - 1) & 1);

                    if (cur == 1) {

                        k--;
                    } else {

                        res = res | ((k - 1) << 1);

                        break;

                    }

                }
            } else { // find i index --> set 0
                int digit = oper[i].charAt(1) - '0';
                res = res & (~(n - digit - 1));

            }

        }
        return Integer.toBinaryString(res);

    }
}
