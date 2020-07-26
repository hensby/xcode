import java.util.LinkedList;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        char[] stack = new char[len];
        int count = 0;
        for (int i = 0;i < len;i ++){
            while(count != 0 && k > 0 && num.charAt(i) < stack[count - 1]){//根据贪心算法删除比后一个大的值
                count --;
                k --;
                System.out.println(count);
            }
            stack[count ++] = num.charAt(i);
            System.out.println(2);
        }
        int start = 0;
        while(start < count && stack[start] == '0') start ++;
        return start >= count - k ? "0" : new String(stack,start,count - start - k);
    }

    public String removeKdigits1(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                System.out.println(stack.peek());
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        System.out.println(stack);
        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }
        System.out.println(stack);
        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }

    public static void main(String[] args) {
        String input = "12345264";
        RemoveKdigits r = new RemoveKdigits();
        System.out.println(r.removeKdigits1(input, 3));
    }

}
