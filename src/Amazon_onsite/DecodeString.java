package Amazon_onsite;

import java.util.LinkedList;

public class DecodeString {

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            System.out.println(stack_multi);
            System.out.println(stack_res);
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

}
//394. Decode String
//        Given an encoded string, return its decoded string.
//
//        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//        Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//
//
//        Example 1:
//
//        Input: s = "3[a]2[bc]"
//        Output: "aaabcbc"
//        Example 2:
//
//        Input: s = "3[a2[c]]"
//        Output: "accaccacc"
//        Example 3:
//
//        Input: s = "2[abc]3[cd]ef"
//        Output: "abcabccdcdcdef"
//        Example 4:
//
//        Input: s = "abc3[cd]xyz"
//        Output: "abccdcdcdxyz"
//
//
//        Constraints:
//
//        1 <= s.length <= 30
//        s consists of lowercase English letters, digits, and square brackets '[]'.
//        s is guaranteed to be a valid input.
//        All the integers in s are in the range [1, 300].
