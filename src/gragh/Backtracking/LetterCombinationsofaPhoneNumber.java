package gragh.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

    List<String> res = new ArrayList<String>();
    Map<Character, char[]> digitMap = new HashMap<Character, char[]>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(digits, sb);
        return res;
    }

    public void dfs(String digits, StringBuilder sb) {
        if (digits == null || digits.length() == 0) {
            res.add(sb.toString());
            return;
        }
        char flag = digits.charAt(0);
        for (char c : digitMap.get(flag)) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(c);
            dfs(digits.substring(1), newSb);
        }
        return;
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber letter = new LetterCombinationsofaPhoneNumber();
        System.out.println(letter.letterCombinations("23"));
    }
}
//17. Letter Combinations of a Phone Number
//        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//        Example 1:
//
//        Input: digits = "23"
//        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        Example 2:
//
//        Input: digits = ""
//        Output: []
//        Example 3:
//
//        Input: digits = "2"
//        Output: ["a","b","c"]